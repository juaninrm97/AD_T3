package es.studium.Practica;



import es.studium.Practica.HotelManager;
import es.studium.Practica.Cliente;

public class TestHotel {
    public static void main(String[] args) {
        HotelManager manager = new HotelManager();

        // Crear cliente
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setApellidos("Pérez");
        cliente.setEmail("juan.perez@example.com");
        cliente.setDni("12345678A");
        cliente.setClave("securePassword");
        manager.crearCliente(cliente);

        // Leer clientes
        System.out.println("Clientes:");
        manager.leerClientes().forEach(c -> 
            System.out.println(c.getIdCliente() + " - " + c.getNombre() + " " + c.getApellidos() + c.getEmail()+ " - " + c.getDni()+ " - " + c.getClave())
        );

        // Actualizar cliente
        manager.actualizarCliente(cliente.getIdCliente(), "nuevo.email@example.com");

        // Eliminar cliente
        manager.eliminarCliente(cliente.getIdCliente());
    }
}
