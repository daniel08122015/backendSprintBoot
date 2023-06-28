package com.example.reservabackmathews.service;
import com.example.reservabackmathews.dtos.UsuarioCreateDTO;
import com.example.reservabackmathews.dtos.UsuarioDTO;
import com.example.reservabackmathews.dtos.UsuarioUpdateDTO;
import com.example.reservabackmathews.mappers.UsuarioMapper;
import com.example.reservabackmathews.model.Usuario;
import com.example.reservabackmathews.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return UsuarioMapper.instancia.listaUsuarioAListaUsuarioDTO( usuarioRepository.findAll());
    }

    @Override
    public UsuarioDTO obtenerUsuarioPorID(long id) {
        Optional<Usuario> usuario= usuarioRepository.findById(id);
        UsuarioDTO usuarioDTO ;
        if(usuario.isPresent()){
            usuarioDTO = UsuarioMapper.instancia.usuarioAUsuarioDTO(usuario.get());
        }else {
            usuarioDTO=null;
        }
        return  usuarioDTO;
    }

    @Override
    @Transactional
    public UsuarioDTO registrarUsuario(UsuarioCreateDTO usuarioCreateDTO) {

        Usuario usuario=UsuarioMapper.instancia.usuarioCreatedDTOAUsuario(usuarioCreateDTO);

        String encoderPassword= this.passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(encoderPassword);


        Usuario respuestaEntity = usuarioRepository.save(usuario);

        UsuarioDTO respuestaDTO= UsuarioMapper.instancia.usuarioAUsuarioDTO(respuestaEntity);

        return respuestaDTO;



    }

    @Override
    public UsuarioDTO actualizarUsuario(UsuarioUpdateDTO usuarioUpdateDTO) {
        Usuario usuario = UsuarioMapper.instancia.usuarioUpdateDTOAUsuario(usuarioUpdateDTO);
        Usuario respuestaEntity = usuarioRepository.save(usuario);
        UsuarioDTO respuestaDTO= UsuarioMapper.instancia.usuarioAUsuarioDTO(respuestaEntity);
        return respuestaDTO;
    }

    @Override
    public UsuarioDTO eliminarUsuario(long id) {
        Optional<Usuario> usuarioOptional= usuarioRepository.findById(id);
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        String resultado ;
        if(usuarioOptional.isPresent()){
            usuarioDTO=UsuarioMapper.instancia.usuarioAUsuarioDTO(usuarioOptional.get());
            usuarioRepository.delete(usuarioOptional.get());
            return usuarioDTO;
        }else {
            resultado="No se pudo realizar la eliminación";
        }
        return usuarioDTO;
    }
}
