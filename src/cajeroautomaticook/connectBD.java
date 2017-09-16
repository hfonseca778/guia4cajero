/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomaticook;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres Fonseca
 */
public class connectBD {
    
    private  String controlador = "sun.jdbc.odbc.JdbcOdbcDriver";
        
    private static Connection con = null;
    
    public static void conectarBD() {
        try {
            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\CajeroAutomaticoOk\\BD.accdb");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Imposible conectarse a la BD");
            e.printStackTrace();
        }
    }
    
    public static void consultarCuenta(String numeroCuenta, String claveCuenta, MenuOpcionesCajero2 opciones) {
        try {
            String sql = "SELECT * FROM Cuentas WHERE Numero_Cuenta = ? and Clave_Cuenta = ?";
            PreparedStatement st = con.prepareStatement(sql);
            
            
            st.setInt(1,Integer.parseInt(numeroCuenta));
            st.setInt(2,Integer.parseInt(claveCuenta));
            
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                opciones.setVisible(true);
                //JOptionPane.showMessageDialog(null, "número de cuenta o clave correcta");
                
            /**    JOptionPane.showMessageDialog(null, "Información del estudiante " + nombre + 
                        "\nID = " + rs.getInt("ID") + "\n" +
                        "Nombres: " + rs.getString("NombreCompleto") + "\n" + 
                        "Carrera: " + rs.getString("Carrera") + "\n" +
                        "Semestre: " + rs.getInt("Semestre") + "\n" + 
                        "Promedio: " + rs.getDouble("Promedio"));**/
            }
            else {
                JOptionPane.showMessageDialog(null, "número de cuenta o clave incorrecta");
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error grave: " + e.getMessage());
        }
    }
    
    public static int consultarSaldoCuenta(String numeroCuenta, String claveCuenta) {
        int saldo=0;
        try {
            String sql = "SELECT Saldo FROM Cuentas WHERE Numero_Cuenta = ? and Clave_Cuenta = ?";
            PreparedStatement st = con.prepareStatement(sql);
            
            
            st.setInt(1,Integer.parseInt(numeroCuenta));
            st.setInt(2,Integer.parseInt(claveCuenta));
            
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                saldo = rs.getInt("Saldo");
                
            }
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error grave: " + e.getMessage());
        }
        
        return saldo;
    }
    
    public static boolean actualizarSaldo(String numeroCuenta, String claveCuenta, int saldo) {
        try {
            String sql = "UPDATE Cuentas SET Saldo = ? WHERE Numero_Cuenta = ? and Clave_Cuenta = ?";
            PreparedStatement st = con.prepareStatement(sql);
                               
            st.setInt(1, saldo);
            st.setInt(2, Integer.parseInt(numeroCuenta));
            st.setInt(3, Integer.parseInt(claveCuenta));
            
            
            st.executeUpdate();
            return true;
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar saldo");
            e.printStackTrace();
        }
        return false;
    }
    
    public static int consultarClaveCuenta(String numeroCuenta, String claveCuenta) {
        int ClaveVieja=0;
        try {
            String sql = "SELECT Clave_Cuenta FROM Cuentas WHERE Numero_Cuenta = ? and Clave_Cuenta = ?";
            PreparedStatement st = con.prepareStatement(sql);
            
            
            st.setInt(1,Integer.parseInt(numeroCuenta));
            st.setInt(2,Integer.parseInt(claveCuenta));
            
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                ClaveVieja = rs.getInt("Clave_Cuenta");
                
            }
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error grave: " + e.getMessage());
        }
        
        return ClaveVieja;
    }
    
    public static boolean actualizarClave(String numeroCuenta, String claveCuenta, int claveNueva) {
        try {
            String sql = "UPDATE Cuentas SET Clave_Cuenta = ? WHERE Numero_Cuenta = ? and Clave_Cuenta = ?";
            PreparedStatement st = con.prepareStatement(sql);
                               
            st.setInt(1, claveNueva);
            st.setInt(2, Integer.parseInt(numeroCuenta));
            st.setInt(3, Integer.parseInt(claveCuenta));
            
            
            st.executeUpdate();
            return true;
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar clave");
            e.printStackTrace();
        }
        return false;
    }    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static boolean insertarEstudianteEnLaBD(String nombre, String carrera, int sem, double prom) {
        try {
            String sql = "INSERT INTO Estudiante VALUES(0, ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setString(1, nombre);
            st.setString(2, carrera);
            st.setInt(3, sem);
            st.setDouble(4, prom);
            
            st.executeUpdate();
            return true;
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar los estudiantes");
            e.printStackTrace();
        }
        return false;
    }    
    
    public static int obtenerIDDelUltimoEstudiante() {
        try {
            String sql = "SELECT MAX(ID)  FROM Estudiante";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            if (rs.next()) {
                int ultimoID = rs.getInt(1); // Obtenemos la unica respuesta
                return ultimoID;
            }            
            
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error grave: " + e.getMessage());
        }
        return -1;
    }
    
    public static void mostrarInformacionDeUnEstudiante(String nombre) {
        try {
            String sql = "SELECT * FROM Estudiante WHERE NombreCompleto LIKE ?";
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setString(1, "%" + nombre + "%");
            
            ResultSet rs = st.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Información del estudiante " + nombre + 
                        "\nID = " + rs.getInt("ID") + "\n" +
                        "Nombres: " + rs.getString("NombreCompleto") + "\n" + 
                        "Carrera: " + rs.getString("Carrera") + "\n" +
                        "Semestre: " + rs.getInt("Semestre") + "\n" + 
                        "Promedio: " + rs.getDouble("Promedio"));
            }
            else {
                JOptionPane.showMessageDialog(null, "El estudiante con nombre " + nombre +
                        " no existe en la BD");
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error grave: " + e.getMessage());
        }
    }
    
    public static ArrayList<String[]> obtenerTodosLosEstudiantes() {
        try {
            Statement st = con.createStatement();
            String sql = "SELECT * FROM ESTUDIANTE ORDER BY NombreCompleto";
            
            ResultSet rs = st.executeQuery(sql);
            
            ArrayList<String[]> listaEstuds = new ArrayList<>();
            
            while (rs.next()) {
                String[] e = new String[5];
                e[0] = rs.getString(1);
                e[1] = rs.getString(2);
                e[2] = rs.getString(3);
                e[3] = rs.getString(4);
                e[4] = rs.getString(5);
                
                listaEstuds.add(e);
            }
            
            rs.close();
            return listaEstuds;
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return null;
    }
}