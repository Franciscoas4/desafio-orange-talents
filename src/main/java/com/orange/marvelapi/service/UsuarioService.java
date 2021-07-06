package com.orange.marvelapi.service;

import com.orange.marvelapi.dto.UsuarioDTO;
import com.orange.marvelapi.exceptions.CadastroCpfException;
import com.orange.marvelapi.exceptions.CadastroEmailException;
import com.orange.marvelapi.exceptions.UsuarioNaoCadastradoException;
import com.orange.marvelapi.mappers.UsuarioMapper;
import com.orange.marvelapi.model.Usuario;
import com.orange.marvelapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final UsuarioMapper usuarioMapper = UsuarioMapper.INSTANCE;

    private UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioService() {
    }

    public UsuarioDTO cadastrarUsuario(UsuarioDTO usuarioDTO) throws CadastroCpfException, CadastroEmailException {

        verificaCpf(usuarioDTO.getCpf());
        verificaEmail(usuarioDTO.getEmail());

        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        Usuario usuarioCriado = usuarioRepository.save(usuario);

        return usuarioMapper.toDTO(usuarioCriado);

    }

    public List<UsuarioDTO> listarTodos(){

        return usuarioRepository.findAll().stream().map(usuario -> usuarioMapper.toDTO(usuario)).collect(Collectors.toList());

    }

    public void verificaCpf(String cpf) throws CadastroCpfException {

        Optional<Usuario> usuarioCpf = usuarioRepository.findByCpf(cpf);

        if(usuarioCpf.isPresent()) {

            throw new CadastroCpfException(cpf);

        }
    }

    public void verificaEmail(String email) throws CadastroEmailException {

        Optional<Usuario> usuarioEmail = usuarioRepository.findByEmail(email);

        if(usuarioEmail.isPresent()) {

            throw new CadastroEmailException(email);

        }
    }

    public Usuario listarUsuario(Long codigo) throws UsuarioNaoCadastradoException {

        verificaUsuario(codigo);

        return usuarioRepository.findByCodigo(codigo);
    }

    public void verificaUsuario(Long id) throws UsuarioNaoCadastradoException {

        Usuario usuario = usuarioRepository.findByCodigo(id);

        if(usuario == null) {

            throw new UsuarioNaoCadastradoException(id);

        }
    }
}
