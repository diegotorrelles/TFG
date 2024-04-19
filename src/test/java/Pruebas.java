/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author diego
 */

import com.mycompany.giusistemasalud.CentroSaludImpl;
import com.mycompany.giusistemasalud.CitasAnterioresImpl;
import com.mycompany.giusistemasalud.EnfermerosImpl;
import com.mycompany.giusistemasalud.MedicosImpl;
import com.mycompany.giusistemasalud.NotaClinicaImpl;
import com.mycompany.giusistemasalud.PacientesImpl;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class Pruebas {
    
    @Test
	public void testBuscarPacienteExistente() {
		      PacientesImpl miClase = new PacientesImpl();
		String resultadoEsperado = "\nNombre del Paciente:              Diego Torrelles  Rodriguez\n" + 
				"Sexo:                                       Masculino               \n" + 
				"Comunidad donde Reside:        Islas Canarias             \n" + 
				"\n" + 
				"Enfermedades:\n" + 
				"Cálculos biliares: Formación de piedras en la vesícula biliar\n" + 
				"\n" + 
				"Hernia umbilical: Protrusión anormal de una parte del intestino o del tejido "
                        + "abdominal a través de una abertura en los músculos abdominales alrededor del ombligo.\n\n";
		
		String resultadoActual = miClase.buscarPaciente("54883416B");
		
		assertEquals(resultadoEsperado, resultadoActual);
	}
	
        
        
	@Test
	public void testBuscarPacienteNoExistente() {
		PacientesImpl miClase = new PacientesImpl();
		String resultadoEsperado = "No existe ningún medico con ese dni";
		
		String resultadoActual = miClase.buscarPaciente("99999999A");
		
		assertEquals(resultadoEsperado, resultadoActual);
	}
/*        
            @Test
	public void testBuscarCentroSaludPorComunidad() {
		      CentroSaludImpl miClase = new CentroSaludImpl();
		String resultadoEsperado = "Nombre del Centro                                Tipo                        \n" +
"\n" +
"\n" +
"Clínica IMQ Zorrotzaurre                          Privado                                           \n" +
"\n" +
"Especialidades:\n" +
"Inmunología         \n" +
"Medicina de la educación física y del deporte\n" +
"Medicina del trabajo\n" +
"Medicina deportiva  \n" +
"Medicina familiar y comunitaria\n" +
"Medicina intensiva  \n" +
"Medicina interna    \n" +
"Medicina legal y forense\n" +
"Medicina nuclear    \n" +
"Medicina preventiva y salud pública\n" +
"\n" +
"Clínica La Esperanza                              Privado                                           \n" +
"\n" +
"Especialidades:\n" +
"Medicina del sueño  \n" +
"Nefrología          \n" +
"Neumología          \n" +
"Neurocirugía        \n" +
"Neurofisiología clínica\n" +
"Neurología          \n" +
"Obstetricia y ginecología\n" +
"Oftalmología        \n" +
"Oncología médica    \n" +
"Oncología radioterápica\n" +
"\n" +
"Hospital de Basurto                               Público                                           \n" +
"\n" +
"Especialidades:\n" +
"Alergología e inmunología clínica\n" +
"Anestesiología y reanimación\n" +
"Angiología y cirugía vascular\n" +
"Cardiología         \n" +
"Cirugía cardiovascular\n" +
"Cirugía general y del aparato digestivo\n" +
"Cirugía maxilofacial\n" +
"Cirugía ortopédica y traumatología\n" +
"Cirugía pediátrica  \n" +
"Cirugía plástica, estética y reparadora\n" +
"Psiquiatría         \n" +
"\n" +
"Hospital Universitario Cruces                     Público                                           \n" +
"\n" +
"Especialidades:\n" +
"Cirugía torácica    \n" +
"Dermatología médico-quirúrgica y venereología\n" +
"Endocrinología y nutrición\n" +
"Farmacología clínica\n" +
"Gastroenterología   \n" +
"Genética clínica    \n" +
"Geriatría           \n" +
"Ginecología y obstetricia\n" +
"Hematología y hemoterapia\n" +
"Infectología\n         ";
		
		String resultadoActual = miClase.buscarCentroSaludPorComunidades("Pais Vasco");
		
		assertEquals(resultadoEsperado, resultadoActual);
	} */
        
             @Test
	public void testBuscarCentroSaludPorEspecialidad() {
		      CentroSaludImpl miClase = new CentroSaludImpl();
                      String resultadoEsperado = "                                                  Alergología e inmunología clínica\n" +
"\n" +
"\n" +
"Nombre del Centro Sanitario:          Centro Médico de Asturias\n" +
"Tipo del Centro:                             Privado                       \n" +
"Comunidad:                                  Asturias            \n" +
"\n" +
"Nombre del Centro Sanitario:          Clinica de Caceres  \n" +
"Tipo del Centro:                             Privado                       \n" +
"Comunidad:                                  Extremadura         \n" +
"\n" +
"Nombre del Centro Sanitario:          Clínica Juaneda     \n" +
"Tipo del Centro:                             Privado                       \n" +
"Comunidad:                                  Islas Baleares      \n" +
"\n" +
"Nombre del Centro Sanitario:          Clinica los Manzanos\n" +
"Tipo del Centro:                             Privado                       \n" +
"Comunidad:                                  La Rioja            \n" +
"\n" +
"Nombre del Centro Sanitario:          Clinica Nuestra Señora del Rosario\n" +
"Tipo del Centro:                             Privado                       \n" +
"Comunidad:                                  Castilla-La Mancha  \n" +
"\n" +
"Nombre del Centro Sanitario:          Complejo Hospitalario de Navarra\n" +
"Tipo del Centro:                             Público                       \n" +
"Comunidad:                                  Navarra             \n" +
"\n" +
"Nombre del Centro Sanitario:          Hospital Clínico Universitario de Valladolid\n" +
"Tipo del Centro:                             Público                       \n" +
"Comunidad:                                  Castilla y León     \n" +
"\n" +
"Nombre del Centro Sanitario:          Hospital de Basurto \n" +
"Tipo del Centro:                             Público                       \n" +
"Comunidad:                                  País Vasco          \n" +
"\n" +
"Nombre del Centro Sanitario:          Hospital de Cabueñes\n" +
"Tipo del Centro:                             Publico                       \n" +
"Comunidad:                                  Asturias            \n" +
"\n" +
"Nombre del Centro Sanitario:          Hospital de Calahorra\n" +
"Tipo del Centro:                             Publico                       \n" +
"Comunidad:                                  La Rioja            \n" +
"\n" +
"Nombre del Centro Sanitario:          Hospital de Laredo  \n" +
"Tipo del Centro:                             Público                       \n" +
"Comunidad:                                  Cantabria           \n" +
"\n" +
"Nombre del Centro Sanitario:          Hospital General de Albacete\n" +
"Tipo del Centro:                             Publico                       \n" +
"Comunidad:                                  Castilla-La Mancha  \n" +
"\n" +
"Nombre del Centro Sanitario:          Hospital General Universitario de Valencia\n" +
"Tipo del Centro:                             Público                       \n" +
"Comunidad:                                  Comunidad Valenciana\n" +
"\n" +
"Nombre del Centro Sanitario:          Hospital Royo Villanova\n" +
"Tipo del Centro:                             Público                       \n" +
"Comunidad:                                  Aragón              \n" +
"\n" +
"Nombre del Centro Sanitario:          Hospital San Pedro  \n" +
"Tipo del Centro:                             Público                       \n" +
"Comunidad:                                  La Rioja            \n" +
"\n" +
"Nombre del Centro Sanitario:          Hospital Sant Pau   \n" +
"Tipo del Centro:                             Público                       \n" +
"Comunidad:                                  Cataluña            \n" +
"\n" +
"Nombre del Centro Sanitario:          Hospital Universitario Central de Asturias\n" +
"Tipo del Centro:                             Público                       \n" +
"Comunidad:                                  Asturias            \n" +
"\n" +
"Nombre del Centro Sanitario:          Hospital Universitario Virgen del Rocío\n" +
"Tipo del Centro:                             Publico                       \n" +
"Comunidad:                                  Andalucia           \n" +
"\n" +
"Nombre del Centro Sanitario:          Santa Barbara       \n" +
"Tipo del Centro:                             Publico                       \n" +
"Comunidad:                                  Castilla-La Mancha  \n";
                      
                String resultadoActual = miClase.buscarCentroSaludPorEspecialidad("Alergología e inmunología clínica");
		
		assertEquals(resultadoEsperado, resultadoActual);
        }
        
          @Test
    public void testBuscarCitasAnterioresParaPacienteExistente() {
        CitasAnterioresImpl miClase = new CitasAnterioresImpl();
        String dniPaciente = "65478912W";
        String resultadoEsperado = "Nombre del Paciente: Ana García Martínez\n" +
"\n" +
"Atendido En: Hospital Universitario Cruces    En la fecha: 2015-04-17\n" +
"Con motivo de: Consulta\n" +
"Atendido Por: Pedro Sánchez Ramos\n" +
"Especialidad del Medico: Endocrinología y nutrición\n" +
"\n" +
"Atendido En: Clínica IMQ Zorrotzaurre    En la fecha: 2018-02-11\n" +
"Con motivo de: Cirugia\n" +
"Atendido Por: Sandra Hernandez Gomez\n" +
"Especialidad del Medico: Medicina intensiva\n\n";
        
      

            String resultadoObtenido = miClase.buscarCitasAnteriores(dniPaciente);
            assertEquals(resultadoEsperado, resultadoObtenido);
        
    }
    
     @Test
    public void testBuscarCitasAnterioresParaPacienteInexistente() {
        String dniPaciente = "99999999Z";
        CitasAnterioresImpl miClase = new CitasAnterioresImpl();
        String resultadoEsperado = "NO HAY NINGUNA CITA DE ESTE PACIENTE REGISTRADA";
        
            String resultadoObtenido = miClase.buscarCitasAnteriores(dniPaciente);
            assertEquals(resultadoEsperado, resultadoObtenido);
      
        
    }
    
        @Test
    public void testBuscaMedicoExistente() {
        
        MedicosImpl miClase = new MedicosImpl();
        String dni = "54674326N";
        String resultadoEsperado = "Nombre del medico: Mayte    Rodriguez    Vera\n" +
                                "\n" +
                                "Especialidad: Psiquiatría\n" +
                                "\n" +
                                "Centro Sanitario Donde trabaja:  Hospital de Basurto";
        
        String resultadoObtenido = miClase.buscaMedico(dni);
        
        assertEquals(resultadoEsperado, resultadoObtenido);
    } 
    
        @Test
    public void testBuscaMedicoNoExistente() {
        
        MedicosImpl miClase = new MedicosImpl();
        String dni = "54674323N";
        String resultadoEsperado = "No existe ningún medico con ese dni";
        
        String resultadoObtenido = miClase.buscaMedico(dni);
        
        assertEquals(resultadoEsperado, resultadoObtenido);
    }
    
           @Test
    public void testBuscaMedicosPorEspecialidad() {
        
        MedicosImpl miClase = new MedicosImpl();
        String especialidad = "Alergología e inmunología clínica";
        String resultadoEsperado = "Nombre               Apellido             Trabaja En \n" +
"\n" +
"Pablo               González            Clinica Nuestra Señora del Rosario\n" +
"David               García              Hospital de Calahorra\n" +
"Jorge               Gómez               Hospital San Pedro  \n" +
"Ruben               Lopez               Hospital Clínico Universitario de Valladolid\n" +
"Miguel              Martin              Hospital Sant Pau   \n" +
"Alba                Fernandez           Hospital Universitario Virgen del Rocío\n" +
"Lucía               Rodríguez           Clinica los Manzanos\n" +
"Luis                Díaz                Centro Médico de Asturias\n" +
"Daniel              Gomez               Hospital Royo Villanova\n" +
"Sonia               Rodriguez           Hospital de Cabueñes\n" +
"Mario               Sanchez             Clinica de Caceres  \n" +
"Natalia             Perez               Clínica Universidad de Navarra\n" +
"Carmen              Garcia              Hospital General Universitario de Valencia\n" +
"Elena               Hernández           Hospital San Pedro  \n" +
"Ana                 Muñoz               Hospital Universitario Central de Asturias\n" +
"Miguel              Sánchez             Santa Barbara       \n" +
"Sara                Hernández           Hospital de Basurto \n" +
"Ana                 Gonzalez            Hospital de Laredo  \n" +
"Sofia               Sanchez             Clínica Juaneda     \n" +
"Natalia             Pérez               Hospital General de Albacete\n";
        
        String resultadoObtenido = miClase.buscarMedicosEspecialidad(especialidad);
        
        assertEquals(resultadoEsperado, resultadoObtenido);
    } 
    
           @Test
    public void testBuscaEnfermeroExistente() {
        
        EnfermerosImpl miClase = new EnfermerosImpl();
        String dni = "34567789T";
        String resultadoEsperado = "Nombre del Enfermero:           Lucia Fernandez Gomez\n" +
                                    "\n" +
                                    "Especialidad Asignada:           Cardiología\n" +
                                    "\n" +
                                    "Centro Sanitario Donde trabaja:  Clinica Nuestra Señora del Rosario\n" +
                                    "\n" +
                                    "                                              Hospital de Basurto\n" +
                                    "\n" +
                                    "                                              Hospital General de Albacete\n" +
                                    "\n" +
                                    "                                              Hospital Universitario Dr. Peset\n" +
                                    "\n" +
                                    "                                              Santa Barbara\n\n";
        
        String resultadoObtenido = miClase.buscarEnfermero(dni);
        
        assertEquals(resultadoEsperado, resultadoObtenido);
    } 
    
        @Test
    public void testBuscaEnfermeroNoExistente() {
        
        EnfermerosImpl miClase = new EnfermerosImpl();
        String dni = "54674323N";
        String resultadoEsperado = "No existe ningún enfermero con ese dni";
        
        String resultadoObtenido = miClase.buscarEnfermero(dni);
        
        assertEquals(resultadoEsperado, resultadoObtenido);
    }
    
        @Test
    public void testBuscaEnfermerosPorEspecialidad() {
        
        EnfermerosImpl miClase = new EnfermerosImpl();
        String especialidad = "Cardiología";
        String resultadoEsperado = "Nombre               Apellido             Trabaja En \n" +
                            "\n" +
                            "\n" +
                            "Luisa               Martín              Centro Médico de Asturias\n" +
                            "                                                Hospital Universitario Virgen del Rocío\n" +
                            "\n" +
                            "María               García              Hospital Royo Villanova\n" +
                            "                                                Hospital Universitario Virgen de la Arrixaca\n" +
                            "\n" +
                            "Lucia               Fernandez           Clinica Nuestra Señora del Rosario\n" +
                            "                                                Hospital de Basurto \n" +
                            "                                                Hospital General de Albacete\n" +
                            "                                                Hospital Universitario Dr. Peset\n" +
                            "                                                Santa Barbara       \n" +
                            "\n" +
                            "David               Sánchez             Clínica Universidad de Navarra\n" +
                            "                                                Hospital General Yagüe\n" +
                            "\n" +
                            "Carmen              González            Clinica los Manzanos\n" +
                            "                                                Hospital de Calahorra\n" +
                            "                                                Hospital San Pedro  \n" +
                            "                                                Hospital Sant Pau   \n" +
                            "\n" +
                            "José                Lopez               Clinica de Caceres  \n" +
                            "                                                Clínica Juaneda     \n";
        
        String resultadoObtenido = miClase.buscarEnfermerosPorEspecialidad(especialidad);
        
        assertEquals(resultadoEsperado, resultadoObtenido);
    } 
    
    /*
          @Test
    public void testBuscaNotaClinica() {
        NotaClinicaImpl miClase = new NotaClinicaImpl();
        String dni = "65478912W";
        
        String resultadoEsperado = "Nota Clinica:\n" +
                "Especialidad Medica: Endocrinología y nutrición\n" +
                "Fecha: 2023-04-2\n" +
                "Texto: Consulta en la que el paciente ha mejorado en comparacion con los \n" +
                "a como el habia llegado\n" +
                "\n" +
                "Nota Clinica:\n" +
                "Especialidad Medica: Endocrinología y nutrición\n" +
                "Fecha: 2023-05-2\n" +
                "Texto: Consulta dar de alta al paciente\n\n";
        
        String resultadoObtenido = miClase.buscarNotaClinica(dni);
        assertEquals(resultadoEsperado, resultadoObtenido);
        
        
    }
    
          @Test
    public void testAgregaNotaClinica() {
        NotaClinicaImpl miClase = new NotaClinicaImpl();
        
        String resultadoEsperado = "La nota clinica se ha añadido correctamente al historial del paciente";
        String dniPaciente = "65478912W";
        String dniMedico = "23456789V";
        
        String texto= "Esto es la prueba del junit";
        String resultadoObtenido = miClase.agregarNotaClinica(dniPaciente, dniMedico, texto);
        assertEquals(resultadoEsperado, resultadoObtenido);
    } */
}
