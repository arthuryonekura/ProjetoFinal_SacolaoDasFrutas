package com.projetoFinal.sacolaoDasFrutas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.projetoFinal.sacolaoDasFrutas.Entity.Categoria;
import com.projetoFinal.sacolaoDasFrutas.Entity.Fruta;
import com.projetoFinal.sacolaoDasFrutas.Repository.CategoriaRepository;
import com.projetoFinal.sacolaoDasFrutas.Repository.FrutaRepository;
import java.util.List;

@Controller
public class FrutaController {

	private FrutaRepository frutaRepository;
	private CategoriaRepository categoriaRepository;

	@Autowired
	public FrutaController(FrutaRepository frutaRepository, CategoriaRepository categoriaRepository) {
		this.frutaRepository = frutaRepository;
		this.categoriaRepository = categoriaRepository;
	}

	@GetMapping("/cadastrarFruta")
	public String cadastrarFruta(Model model) {
		model.addAttribute("fruta", new Fruta());
		List<Categoria> listaCategorias = categoriaRepository.findAll();
		model.addAttribute("listaCategorias", listaCategorias);
		return "cadastrarFruta";
	}

	@PostMapping("/cadastrarFruta")
	public String addFruta(@ModelAttribute Fruta fruta, Model model) {
		frutaRepository.save(fruta);
		return "redirect:/listarFrutas";
	}

	@GetMapping("/listarFrutas")
	public String listarFrutas(Model model) {
		List<Fruta> lista = frutaRepository.findAll();
		model.addAttribute("listaFrutas", lista);
		return "listarFrutas";
	}

	@GetMapping("/editarFruta/{id}")
	public String editarFruta(@PathVariable Long id, Model model) {
		Fruta fruta = frutaRepository.findById(id).orElse(null);
		List<Categoria> categorias = categoriaRepository.findAll();
		model.addAttribute("fruta", fruta);
		model.addAttribute("listaCategorias", categorias);
		return "editarFruta";
	}

	@PostMapping("/editarFruta")
	public String editarFruta(@ModelAttribute("fruta") Fruta fruta, @RequestParam("id") Long id) {
		fruta.setId(id);
		frutaRepository.save(fruta);
		return "redirect:/listarFrutas";
	}

	@GetMapping("/deletarFruta/{id}")
	public String deletarFruta(@PathVariable Long id) {
		frutaRepository.deleteById(id);
		return "redirect:/listarFrutas";
	}
}