package com.example.demo.controllers;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.models.entity.Cliente;
import com.example.demo.models.entity.Factura;
import com.example.demo.models.entity.ItemFactura;
import com.example.demo.models.entity.Producto;
import com.example.demo.models.service.IClienteService;
@Secured("ROLE_ADMIN")
@Controller
@RequestMapping("/factura")
@SessionAttributes("factura")
public class FacturaController {
    
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable(value="id") Long id,Model model,RedirectAttributes flash,Locale locale){
		Factura factura = clienteService.findFacturabyId(id);
		if(factura == null){
			flash.addFlashAttribute("error",messageSource.getMessage("text.factura.flash.db.error", null, locale));
			return "redirect:/listar";
		}
		model.addAttribute("factura",factura);
		model.addAttribute("titulo",String.format(messageSource.getMessage("text.factura.ver.titulo", null, locale), factura.getDescripcion()));
		return "factura/ver";
	}
	
	@GetMapping("/form/{clienteId}")
	public String crear(@PathVariable(value="clienteId") Long clienteId,Map<String, Object> model,RedirectAttributes flash,Locale locale){
		
		Cliente cliente = clienteService.findOne(clienteId);
		if(cliente == null){
			flash.addFlashAttribute("error",messageSource.getMessage("text.cliente.flash.db.error", null, locale));
			return "redirect:/listar";
		}
		Factura factura = new Factura();
		factura.setCliente(cliente);
		
		model.put("factura", factura);
		model.put("titulo", messageSource.getMessage("text.factura.form.titulo", null, locale));
		return "factura/form";
	}

	@GetMapping(value = "/cargar-productos/{term}", produces = { "application/json" })
	public @ResponseBody List<Producto> cargarProductos(@PathVariable String term) {
		return clienteService.findByNombre(term);
	}
	
	@PostMapping("/form")
	public String guardar(@Valid Factura factura, BindingResult result, Model model,
			@RequestParam(name = "item_id[]", required = false) Long[] itemId,
			@RequestParam(name = "cantidad[]", required = false) Integer[] cantidad, RedirectAttributes flash,
			SessionStatus status,Locale locale) {

		if (result.hasErrors()) {
			model.addAttribute("titulo", messageSource.getMessage("text.factura.form.titulo", null, locale));
			return "factura/form";
		}

		if (itemId == null || itemId.length == 0) {
			model.addAttribute("titulo", messageSource.getMessage("text.factura.form.titulo", null, locale));
			model.addAttribute("error", messageSource.getMessage("text.factura.flash.lineas.error", null, locale));
			return "factura/form";
		}

		for (int i = 0; i < itemId.length; i++) {
			Producto producto = clienteService.findProductoById(itemId[i]);

			ItemFactura linea = new ItemFactura();
			linea.setCantidad(cantidad[i]);
			linea.setProducto(producto);
			factura.addItemFactura(linea);

			//log.info("ID: " + itemId[i].toString() + ", cantidad: " + cantidad[i].toString());
		}

		clienteService.saveFactura(factura);
		status.setComplete();

		flash.addFlashAttribute("success", messageSource.getMessage("text.factura.flash.crear.success", null, locale));

		return "redirect:/ver/" + factura.getCliente().getId();
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash,Locale locale){
		Factura factura = clienteService.findFacturabyId(id);
		if(factura != null){
			clienteService.deleteFactura(id);
			flash.addFlashAttribute("success", messageSource.getMessage("text.factura.flash.eliminar.success", null, locale));
			return "redirect:/ver/"+factura.getCliente().getId();
		}
		flash.addFlashAttribute("error",messageSource.getMessage("text.factura.flash.db.error", null, locale));
		return "redirect:/listar";
	}
	
}
