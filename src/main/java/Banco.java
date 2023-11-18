import java.util.ArrayList;
import java.util.List;

/*

 */

/**
 *
 * @author julia
 */
public class Banco {
    
    List <Cuenta> cuentas;
    Admin admin;

    public Banco(Admin admin) {
        this.admin = admin;
        this.cuentas = new ArrayList();
    }
    
    public boolean crearCuenta(Cuenta cuenta) {        
        this.cuentas.add(cuenta);
        return true;   
    }
    
        
}
