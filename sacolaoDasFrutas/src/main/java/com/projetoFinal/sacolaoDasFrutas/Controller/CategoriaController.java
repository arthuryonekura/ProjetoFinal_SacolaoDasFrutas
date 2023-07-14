package com.projetoFinal.sacolaoDasFrutas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.projetoFinal.sacolaoDasFrutas.Entity.Categoria;
import com.projetoFinal.sacolaoDasFrutas.Repository.CategoriaRepository;
import java.util.List;

@Controller
public class CategoriaController {

	private CategoriaRepository categoriaRepository;

	@Autowired
	public CategoriaController(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	@GetMapping("/cadastrarCategoria")
	public String cadastrarCategoria(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "cadastrarCategoria";
	}

	@PostMapping("/cadastrarCategoria")
	public String addCategoria(@ModelAttribute Categoria categoria, Model model) {
		categoriaRepository.save(categoria);
		return "redirect:/listarCategorias";
	}

	@GetMapping("/listarCategorias")
	public String listarCategorias(Model model) {
		List<Categoria> lista = categoriaRepository.findAll();
		model.addAttribute("listaCategorias", lista);
		return "listarCategorias";
	}

	@GetMapping("/editarCategoria/{id}")
	public String editarCategoria(@PathVariable Long id, Model model) {
		Categoria categoria = categoriaRepository.findById(id).orElse(null);
		model.addAttribute("categoria", categoria);
		return "editarCategoria";
	}

	@PostMapping("/editarCategoria")
	public String editarCategoria(@ModelAttribute("categoria") Categoria categoria, @RequestParam("id") Long id) {
		categoria.setId(id);
		categoriaRepository.save(categoria);
		return "redirect:/listarCategorias";
	}

	@GetMapping("/deletarCategoria/{id}")
	public String deletarCategoria(@PathVariable Long id) {
		categoriaRepository.deleteById(id);
		return "redirect:/listarCategorias";
	}
}