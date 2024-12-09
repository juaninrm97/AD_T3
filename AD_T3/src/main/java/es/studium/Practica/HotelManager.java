package es.studium.Practica;


import es.studium.Practica.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HotelManager {
    private static SessionFactory factory;

    static {
        factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public void crearCliente(Cliente cliente) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(cliente);
            tx.commit();
        }
    }

    public List<Cliente> leerClientes() {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM Cliente", Cliente.class).list();
        }
    }

    public void actualizarCliente(int id, String nuevoEmail) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Cliente cliente = session.get(Cliente.class, id);
            if (cliente != null) {
                cliente.setEmail(nuevoEmail);
                session.update(cliente);
            }
            tx.commit();
        }
    }

    public void eliminarCliente(int id) {
        try (Session session = factory.openSession()) {
            Transaction tx = session.beginTransaction();
            Cliente cliente = session.get(Cliente.class, id);
            if (cliente != null) {
                session.delete(cliente);
            }
            tx.commit();
        }
    }
}
