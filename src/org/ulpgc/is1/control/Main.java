package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;

import java.util.Date;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RepairManager repairManager = new RepairManager();

        // i. Init. Crear el perfil de dos mecánicos.
        Mechanic mechanic1 = new Mechanic("Javier", "Monleón Peña", repairManager);
        Mechanic mechanic2 = new Mechanic("Maria", "López de Castellón", repairManager);
        repairManager.addMechanic(mechanic1.getName() + mechanic1.getSurname(), mechanic1);
        repairManager.addMechanic(mechanic2.getName() + mechanic2.getSurname(), mechanic2);
        System.out.println("Perfiles de mecánicos creados con éxito.");

        // ii. Init. Crear el perfil de dos vehículos con sus respectivos clientes.
        Phone phone1 = new Phone("123456789"); //Si el teléfono no tiene 9 dígitos saltará una excepción
        Phone phone2 = new Phone("123456789");

        Customer customer1 = new Customer("Juan Perez", phone1);
        Customer customer2 = new Customer("Ana Gomez", phone2);

        Plate plate1 = new Plate("ABC123");
        Plate plate2 = new Plate("XYZ789");

        Vehicle vehicle1 = new Vehicle("Toyota", "Corolla", plate1, customer1, repairManager);
        Vehicle vehicle2 = new Vehicle("Honda", "Civic", plate2, customer2, repairManager);

        repairManager.addVehicle(vehicle1.getModel(), vehicle1);
        repairManager.addVehicle(vehicle2.getModel(), vehicle2);

        System.out.println("Perfiles de vehículos y clientes creados con éxito.");

        // iii. Init. Crear dos piezas en el stock del taller.
        SparePart part1 = new SparePart("Filtro de aceite", 50, repairManager);
        SparePart part2 = new SparePart("Bujía", 110, repairManager);
        repairManager.addPart(part1);
        repairManager.addPart(part2);
        System.out.println(part1.getName() + " y " + part2.getName() + " han sido creadas correctamente y tienen un precio de "
                + part1.getPrice() + " y " + part2.getPrice() + " respectivamente.");

        // iv. Imprimir por pantalla todos los datos del primer mecánico.
        System.out.println("Mecánico 1 -> " + "Nombre: " + mechanic1.getName() + ", Apellido: " + mechanic1.getSurname() +
                ", Reparaciones: " + mechanic1.getRepairManager().getRepairs());

        // v. Imprimir por pantalla todos los datos del segundo vehículo.
        System.out.println("Vehículo 2 -> "
                + ", Marca: " + vehicle2.getMake()
                + ", Modelo: " + vehicle2.getModel()
                + ", Matrícula: " + vehicle2.getPlate().isValid()
                + ", Propietario: " + vehicle2.getOwner().getName()
                + ", Teléfono del propietario: " + vehicle2.getOwner().getPhone().isValid());

        // vi. Registrar una reparación que realiza el primer mecánico sobre el segundo vehículo.
        List<SparePart> spareParts = Arrays.asList(part1, part2);
        Payment payment = new Payment(new Date(), 1500);
        Repair repair = new Repair(new Date(), "Arreglo de motor", 5, payment, BreakdownTypes.MECHANICAL, spareParts, vehicle2);
        repairManager.addRepair(repair);
        System.out.println("Reparación de -> " + repair.getDescription() + " <- completada.");
        repairManager.repair(repair);

        // vii. Formalizar el pago de la reparación anterior.
        System.out.println("Pago formalizado -> " + repair.getPayment());

        // viii. Borrar el primer vehículo.
        repairManager.removeVehicle(vehicle1.getModel());
        if (repairManager.getVehicle(vehicle1.getModel()) == null) {
            System.out.println("El primer vehículo ha sido eliminado correctamente.");
        }

        // ix. Imprimir por pantalla el número de vehículos del taller.
        System.out.println("Número de vehículos en el taller: " + repairManager.getNumberOfVehicles());

        // x. Imprimir por pantalla toda la información de la reparación.
        System.out.println("Reparación -> "+ "Fecha: " + repair.getDate()
                + ", ID: " + repair.getID()
                + ", Descripción: " + repair.getDescription()
                + ", Esfuerzo: " + repair.getEffort()
                + ", Pago de: " + repair.getPayment().amount()
                + ", Tipo: " + repair.getType()
                + ", Partes reemplazadas: " + repair.getPartsReplaced()
                + ", Vehículo: " + repair.getVehicle().getModel());
    }
}
