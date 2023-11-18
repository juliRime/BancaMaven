import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        List <Cuenta> cuentas = new ArrayList<>();

        Scanner leer = new Scanner(System.in).useDelimiter("\n");

        while(true) {
            
            System.out.println("Ingrese la opción del menú que quiera realizar");
            System.out.println("1. Crear una nueva cuenta");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Ver el saldo");
            System.out.println("5. Transferir");
            
            int opcion = leer.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("Ingrese el nombre de usuario");
                    String nombre = leer.next();
                    System.out.println("Ingrese la contraseña");
                    String contrasena = leer.next();                    
                    System.out.println("Ingrese el saldo inicial");
                    double saldoInicial = leer.nextDouble();
                    
                    Cuenta cuenta = new Cuenta(nombre, contrasena, saldoInicial);                    
                    cuentas.add(cuenta);
                    break;
                case 2:
                    imprimirCuentas(cuentas);
                    System.out.println( "Ingrese el indice de la cuenta a la que quiere depositar: ");
                    int indice = leer.nextInt();
                    Cuenta cuentaDpositar = cuentas.get(indice);
                    System.out.println("Cuánto dinero desea depositar?");
                    double valor = leer.nextDouble();
                    cuentaDpositar.depositar(valor);
                    break;
                case 3:
                    imprimirCuentas(cuentas);
                    System.out.println("Ingrese el indice de la cuenta de la que quiere retirar:");
                    int indic = leer.nextInt();
                    Cuenta cuentaRetirar = cuentas.get(indic);
                    System.out.println("Ingrese la contraseña de la cuenta: ");
                     String clave = leer.next();
                     if (cuentaRetirar.getContrasena().equals(clave)){
                         System.out.println("Bienvenido; cuánto desea retirar? ");
                         double depositara = leer.nextDouble();
                         cuentaRetirar.retirar(depositara);
                         System.out.println("Retiro realizado satisfactoriamente");
                     } else {
                         System.out.println("Contraseña incorrecta ");
                     }
                    break;
                case 4:                    
                    break;
                case 5:
                    imprimirCuentas(cuentas);
                    System.out.println("Ingrese el indice de la cuenta de origen de la transferencia: ");
                    int index = leer.nextInt();
                    Cuenta cuentaOrigen = cuentas.get(index);
                    System.out.println("Ingrese la contraseña de la cuenta: ");
                    String clav = leer.next();
                    if (cuentaOrigen.getContrasena().equals(clav)){
                        imprimirCuentas(cuentas);
                        System.out.println("Bienvenido; elija la cuenta de destino de la transferencia:  ");
                        int indixe = leer.nextInt();
                        Cuenta cuentaDestino = cuentas.get(indixe);
                        System.out.println("Ingrese la cantidad que desea transferir: ");
                        double money = leer.nextDouble();
                        cuentaOrigen.transferencia(cuentaDestino, money);
                        imprimirCuentas(cuentas);
                    } else {
                        System.out.println("Contraseña incorrecta ");
                    }

                    break;


            }

        }
        
    }
    
    public static void imprimirCuentas(List<Cuenta> cuentas){
        for (int i = 0; i < cuentas.size(); i++) {
            System.out.println(i + " -> " + cuentas.get(i));            
        }
    }
}
