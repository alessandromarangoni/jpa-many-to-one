package it.betacon.seivice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import it.betacon.entity.Department;
import it.betacon.entity.Employee;

public class MainToOne {

	public static void main(String[] args) {
		
	// Creazione dell'EntityManagerFactory basato sul file di configurazione "persistence.xml"
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("JPAMTO");
    // Creazione dell'EntityManager
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
        
        Department department = new Department();
        department.setName("Development");
        entityManager.persist(department);
       
     // Creazione di un oggetto Employee e impostazione dei suoi attributi
        Employee employee = new Employee();
        employee.setEname("Maria");
        employee.setSalary(2000);
        employee.setDeg("Java Developer");
        employee.setDepartment(department);
        
     // Creazione di un altro oggetto Employee e impostazione dei suoi attributi
        Employee employee2 = new Employee();
        employee2.setEname("Sergio");
        employee2.setSalary(2100);
        employee2.setDeg("Php Developer");
        employee2.setDepartment(department);
        
        
        entityManager.persist(employee);
        entityManager.persist(employee2);
      // Commit della transazione, che salverà effettivamente le modifiche nel database
        entityManager.getTransaction().commit();

      // Chiusura dell'EntityManager e dell'EntityManagerFactory
        entityManager.close();
        emFactory.close();
	}

}
