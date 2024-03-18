import java.util.Objects;

public class Organization implements Cloneable {

   private String organizationCode;
   private String organizationName;
   private String organizationAddress;

   public Organization(String organizationCode, String organizationName, String organizationAddress) {
       this.organizationCode = organizationCode;
       this.organizationName = organizationName;
       this.organizationAddress = organizationAddress;
   }

   public void printDetails() {
       System.out.println("Organization Code: " + organizationCode);
       System.out.println("Organization Name: " + organizationName);
       System.out.println("Organization Address: " + organizationAddress);
   }

   @Override
   public Organization clone() throws CloneNotSupportedException {
       // Ensure deep cloning for nested objects if needed
       Organization cloned = (Organization) super.clone();
       cloned.organizationAddress = Objects.requireNonNullElse(cloned.organizationAddress, organizationAddress); // Address might be mutable
       return cloned;
   }

   public static void main(String[] args) {
       try {
           Organization org1 = new Organization("Rahi", "RIC Industry", "vsp");

           // Create a clone of org1
           Organization org2 = org1.clone();

           // Print the details of both organizations
           System.out.println("Original Organization:");
           org1.printDetails();

           System.out.println("\nCopied Organization:");
           org2.printDetails();
       } catch (CloneNotSupportedException e) {
           System.out.println("Cloning not supported for Organization.");
       }
   }
}
