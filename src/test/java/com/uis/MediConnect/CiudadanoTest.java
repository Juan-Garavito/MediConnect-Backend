package com.uis.MediConnect;


import com.uis.MediConnect.Config.AESEncryption;
import com.uis.MediConnect.DTO.CiudadanoDTO;
import com.uis.MediConnect.Model.Ciudadano;
import com.uis.MediConnect.Service.CiudadanoService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CiudadanoTest {

    @Autowired
    private AESEncryption aesEncryption;
    @Autowired
    private CiudadanoService ciudadanoService;
    private Ciudadano ciudadano;
    private String contraseña;
    private String contraseñaCifrada;

    @BeforeEach
    public void setUp() throws Exception {
        contraseña = "contra123";
        contraseñaCifrada = aesEncryption.cifrar(contraseña);

        ciudadano = new Ciudadano();
        ciudadano.setNumerodocumento("1003459569");
        ciudadano.setNombres("Fabian");
        ciudadano.setApellidos("Martinez");
        ciudadano.setDireccion("Cra 3 #35-3");
        ciudadano.setFechanacimiento(LocalDate.parse("2002-05-05"));
        ciudadano.setIdgenero(1);
        ciudadano.setIdtiposangre(1);
        ciudadano.setUrlimagenperfil(null);
        ciudadano.setCorreo("martin@gmail.com");
        ciudadano.setPassword(contraseña);
        ciudadano.setNumerocelular("3103162057");

    }

    @Test
    @Order(1)
    public void crearciudadanoConContraseñaEncriptada(){
        System.out.println(ciudadano);
        Ciudadano ciudadanoGuardado = ciudadanoService.guardarCiudadano(ciudadano, null);
        ciudadano.setPassword(contraseñaCifrada);
        Assertions.assertTrue(ciudadano.equals(ciudadanoGuardado), "El ciudadano guardado no coincide con el ciudadano esperado");
        Assertions.assertFalse(contraseña.equals(ciudadanoGuardado.getPassword()), "La contraseña no se encripto es la misma");
        System.out.println(ciudadanoGuardado);
        System.out.println("Contraseña cifrada: " + contraseñaCifrada);
    }

    @Test
    @Order(2)
    public void loginCiudadanoConContraseñaEncriptada(){
        CiudadanoDTO ciudadanoDTO = ciudadanoService.loginCiudadano(ciudadano.getPassword(), ciudadano.getCorreo());
        Assertions.assertTrue(!ciudadanoDTO.equals(null), "No se encontro el usuario");
        Assertions.assertTrue(ciudadanoDTO.getNumerodocumento().equals(ciudadano.getNumerodocumento()), "El ciudadano no es el correcto");
        System.out.println("Ciudadano traido: " + ciudadanoDTO);
    }

    @Test
    @Order(3)
    public void loginCiudadanoConContraseñaEncriptadaFallido(){
        CiudadanoDTO ciudadanoDTO = ciudadanoService.loginCiudadano("akslasjkfn", "asfasfas");
        Assertions.assertTrue(ciudadanoDTO == null, "Se encntro un usuario y no es null");
        System.out.println("Ciudadano traido: " + ciudadanoDTO);
    }

    @Test
    @Order(4)
    public void editarCiudadano() throws Exception {
        String nuevaContraseña = "nuevacontrase";
        String nuevaContraseñaCifrada = aesEncryption.cifrar(nuevaContraseña);
        ciudadano.setNombres("Fabiano");
        ciudadano.setPassword(nuevaContraseña);
        ciudadano.setNumerocelular("312312312");
        Ciudadano ciudadanoEditado = ciudadanoService.editarCiudadano(ciudadano);
        Assertions.assertTrue(ciudadano.equals(ciudadanoEditado), "El ciudadano guardado no coincide con el ciudadano esperado");
        Assertions.assertFalse(nuevaContraseña.equals(ciudadanoEditado.getPassword()), "La contraseña no se encripto. es la misma");
        System.out.println(ciudadanoEditado);
        System.out.println("Contraseña cifrada: " + nuevaContraseñaCifrada);
    }

    @Test
    @Order(4)
    public void eliminarCiudadano() throws Exception {
        Ciudadano ciudadanoEliminado = ciudadanoService.eliminarCiudadano(ciudadano.getNumerodocumento());
        Assertions.assertTrue(ciudadanoEliminado != null, "El ciudadano no se pudo eliminar");
        System.out.println("Ciudadano eliminado: " + ciudadanoEliminado);
    }
}
