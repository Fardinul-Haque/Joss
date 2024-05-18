package vehicleservicecentersystem;
import java.util.*;

class ServiceRequest {
    private static int counter = 0;
    private int requestId;
    private String customerName;
    private String vehicleDetails;
    private String issueDescription;
    private RepairStatus repairStatus;

    public ServiceRequest(String customerName, String vehicleDetails, String issueDescription) {
        this.requestId = ++counter;
        this.customerName = customerName;
        this.vehicleDetails = vehicleDetails;
        this.issueDescription = issueDescription;
        this.repairStatus = new RepairStatus("Pending");
    }

    public int getRequestId() {
        return requestId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getVehicleDetails() {
        return vehicleDetails;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public RepairStatus getRepairStatus() {
        return repairStatus;
    }

    public void displayDetails() {
        System.out.println("Request ID: " + requestId);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Vehicle Details: " + vehicleDetails);
        System.out.println("Issue Description: " + issueDescription);
        System.out.println("Repair Status: " + repairStatus.getStatus());
    }
}

class Technician {
    private String name;
    private String specialization;
    private int experience;

    public Technician(String name, String specialization, int experience) {
        this.name = name;
        this.specialization = specialization;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getExperience() {
        return experience;
    }
}

class Vehicle {
    private String make;
    private String model;
    private int year;
    private String VIN;

    public Vehicle(String make, String model, int year, String VIN) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.VIN = VIN;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getVIN() {
        return VIN;
    }
}

class RepairStatus {
    private String status;

    public RepairStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

class Invoice {
    private static int counter = 0;
    private int invoiceId;
    private int requestId;
    private double amount;
    private String date;

    public Invoice(int requestId, double amount, String date) {
        this.invoiceId = ++counter;
        this.requestId = requestId;
        this.amount = amount;
        this.date = date;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public int getRequestId() {
        return requestId;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public void displayDetails() {
        System.out.println("Invoice ID: " + invoiceId);
        System.out.println("Request ID: " + requestId);
        System.out.println("Amount: $" + amount);
        System.out.println("Date: " + date);
    }
}

class Part {
    private static int counter = 0;
    private int partId;
    private String name;
    private double cost;
    private boolean availability;

    public Part(String name, double cost, boolean availability) {
        this.partId = ++counter;
        this.name = name;
        this.cost = cost;
        this.availability = availability;
    }

    public int getPartId() {
        return partId;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void displayDetails() {
        System.out.println("Part ID: " + partId);
        System.out.println("Part Name: " + name);
        System.out.println("Cost: $" + cost);
        System.out.println("Availability: " + (availability ? "In Stock" : "Out of Stock"));
    }
}

class Job {
    private static int counter = 0;
    private int jobId;
    private String description;
    private Part part;
    private Technician technician;

    public Job(String description, Part part, Technician technician) {
        this.jobId = ++counter;
        this.description = description;
        this.part = part;
        this.technician = technician;
    }

    public int getJobId() {
        return jobId;
    }

    public String getDescription() {
        return description;
    }

    public Part getPart() {
        return part;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void displayDetails() {
        System.out.println("Job ID: " + jobId);
        System.out.println("Description: " + description);
        System.out.println("Part: " + part.getName());
        System.out.println("Technician: " + technician.getName());
    }
}

class Customer {
    private static int counter = 0;
    private int customerId;
    private String name;
    private String contactInformation;
    private List<ServiceRequest> serviceHistory;

    public Customer(String name, String contactInformation) {
        this.customerId = ++counter;
        this.name = name;
        this.contactInformation = contactInformation;
        this.serviceHistory = new ArrayList<>();
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getContactInformation() {
        return contactInformation;
    }

    public List<ServiceRequest> getServiceHistory() {
        return serviceHistory;
    }

    public void addServiceRequest(ServiceRequest request) {
        serviceHistory.add(request);
    }

    public void displayDetails() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Contact Information: " + contactInformation);
        System.out.println("Service History:");
        for (ServiceRequest request : serviceHistory) {
            request.displayDetails();
        }
    }
}

public class VehicleServiceCenterSystem {
    public static void main(String[] args) {
        ServiceRequest serviceRequest = new ServiceRequest("John Doe", "Toyota Camry", "Engine noise");
        serviceRequest.displayDetails();

        Technician technician = new Technician("Alice", "Engine Specialist", 5);
        System.out.println("Technician Name: " + technician.getName());

        Vehicle vehicle = new Vehicle("Toyota", "Camry", 2020, "12345ABCDE");
        System.out.println("Vehicle Make: " + vehicle.getMake());

        serviceRequest.getRepairStatus().setStatus("In Progress");
        System.out.println("Updated Repair Status: " + serviceRequest.getRepairStatus().getStatus());

        Invoice invoice = new Invoice(serviceRequest.getRequestId(), 200.0, "2024-05-18");
        invoice.displayDetails();

        Part part = new Part("Brake Pad", 50.0, true);
        part.displayDetails();

        Job job = new Job("Replace brake pads", part, technician);
        job.displayDetails();

        Customer customer = new Customer("John Doe", "john.doe@example.com");
        customer.addServiceRequest(serviceRequest);
        customer.displayDetails();
    }
}
