package org.ulpgc.is1.control;

import org.ulpgc.is1.model.*;

import java.util.Date;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void init(RepairManager manager) {
        // i. Crear el perfil de dos mecánicos.
        Mechanic mechanic1 = new Mechanic("Javier", "Monleón Peña");
        Mechanic mechanic2 = new Mechanic("Maria", "López de Castellón");

        manager.addMechanic(mechanic1);
        manager.addMechanic(mechanic2);
        System.out.println("Perfiles de mecánicos creados con éxito.");

        // ii. Crear el perfil de dos vehículos con sus respectivos clientes.
        Phone phone1 = new Phone("123456789");
        Phone phone2 = new Phone("987654321");

        // Validar los números de teléfono
        if (!phone1.isValid()) {
            System.out.println("El número de teléfono de phone1 no es válido.");
        }
        if (!phone2.isValid()) {
            System.out.println("El número de teléfono de phone2 no es válido.");
        }

        Customer customer1 = new Customer("Juan Perez", phone1);
        Customer customer2 = new Customer("Ana Gomez", phone2);

        Plate plate1 = new Plate("ABC123");
        Plate plate2 = new Plate("XYZ789");

        Vehicle vehicle1 = new Vehicle("Toyota", "Corolla", plate1, customer1, manager);
        Vehicle vehicle2 = new Vehicle("Honda", "Civic", plate2, customer2, manager);

        manager.addVehicle(vehicle1);
        manager.addVehicle(vehicle2);
        System.out.println("Perfiles de vehículos creados con éxito.");

        // iii. Crear dos piezas en el stock del taller.
        SparePart part1 = new SparePart("Filtro de aceite", 50, manager);
        SparePart part2 = new SparePart("Bujía", 110, manager);

        manager.addPart(part1);
        manager.addPart(part2);
        System.out.println("Piezas en el stock del taller creadas con éxito.");
    }

    public static void main(String[] args) {
        RepairManager repairManager = new RepairManager();
        init(repairManager);

        // iv. Imprimir por pantalla todos los datos del primer mecánico.
        System.out.println(repairManager.getMechanic(0));

        // v. Imprimir por pantalla todos los datos del segundo vehículo.
        System.out.println(repairManager.getVehicle(1));

        // vi. Registrar una reparación que realiza el primer mecánico sobre el segundo vehículo.
        SparePart sparePart1 = repairManager.getParts("Filtro de aceite");
        SparePart sparePart2 = repairManager.getParts("Bujía");
        List<SparePart> spareParts = Arrays.asList(sparePart1, sparePart2);

        Payment payment = new Payment(new Date(), 15000);
        Vehicle vehicle2 = repairManager.getVehicle(1);
        Repair repair = new Repair(new Date(), "Arreglo de motor", 5, payment, BreakdownTypes.MECHANICAL, spareParts, vehicle2);

        repairManager.repair(repair);

        // vii. Formalizar el pago de la reparación anterior.
        System.out.println("Pago formalizado -> " + repair.getPayment());

        // viii. Borrar el primer vehículo.
        Vehicle vehicle1 = repairManager.getVehicle(0);
        repairManager.removeVehicle(vehicle1.getModel());

        // Verificar si el primer vehículo ha sido eliminado
        if (repairManager.getVehicle(vehicle1.getModel()) == null) {
            System.out.println("El primer vehículo ha sido eliminado correctamente.");
        }

        // ix. Imprimir por pantalla el número de vehículos del taller.
        System.out.println("Número de vehículos en el taller: " + repairManager.getNumberOfVehicles());

        // x. Imprimir por pantalla toda la información de la reparación.
        System.out.println("Reparación -> "
                + "Fecha: " + repair.getDate()
                + ", ID: " + repair.getID()
                + ", Descripción: " + repair.getDescription()
                + ", Esfuerzo: " + repair.getEffort()
                + ", Tipo: " + repair.getType()
                + ", Vehículo: " + repair.getVehicle().getModel()
                + ", Partes reemplazadas: ");

        for (SparePart part : repair.getPartsReplaced()) {
            System.out.println(" - " + part.getName());
        }

    }
}
