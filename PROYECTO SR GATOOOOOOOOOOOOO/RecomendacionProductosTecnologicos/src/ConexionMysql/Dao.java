/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ConexionMysql;

/**
 *
 * @author nelsoncuenta
 */
public class Dao {
    
    private static DaoAdmin daoAdmin;
    private static DaoCompra daoCompra;
    private static DaoPc daoPc;
    private static DaoUsuario daoUsuario;
    private static DaoLaptop daoLaptop;
    private static DaoImpresora daoImpresora;
    private static DaoTablet daoTablet;
    private static DaoComplementos daoComple;
    
    
    
    static {
    daoAdmin = new DaoAdmin();
    daoCompra = new DaoCompra();
    daoPc = new DaoPc();
    daoUsuario = new DaoUsuario();
    daoLaptop = new DaoLaptop();
    daoImpresora = new DaoImpresora();
    daoTablet=new DaoTablet();
    daoComple = new DaoComplementos();
        }

    public static DaoComplementos getDaoComple() {
        return daoComple;
    }


    public static DaoImpresora getDaoImpresora() {
        return daoImpresora;
    }
    

    public static DaoAdmin getDaoAdmin() {
        return daoAdmin;
    }

    public static DaoCompra getDaoCompra() {
        return daoCompra;
    }

    public static DaoPc getDaoPc() {
        return daoPc;
    }

    public static DaoUsuario getDaoUsuario() {
        return daoUsuario;
    }

    public static DaoLaptop getDaoLaptop() {
        return daoLaptop;
    }

    public static DaoTablet getDaoTablet() {
        return daoTablet;
    }
    
    
    
}
