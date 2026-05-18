/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import modelo.Funcionario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    // ── LISTAR TODOS ──────────────────────────────────
    public List<Funcionario> listarTodos() throws Exception {
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT id_funcionario, cedula, nombre, apellido, email, telefono, fecha_ingreso FROM funcionario";
        try (Connection con = ConexionBD.obtenerConexion();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Funcionario(
                    rs.getInt("id_funcionario"),
                    rs.getString("cedula"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("email"),
                    rs.getString("telefono"),
                    rs.getString("fecha_ingreso")
                ));
            }
        }
        return lista;
    }

    // ── CREAR ─────────────────────────────────────────
    public void crear(Funcionario f) throws Exception {
        String sql = "INSERT INTO funcionario (cedula, nombre, apellido, email, telefono, fecha_ingreso, id_departamento, id_cargo) "+
                     "VALUES (?, ?, ?, ?, ?, ?, 1, 1)";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, f.getCedula());
            ps.setString(2, f.getNombre());
            ps.setString(3, f.getApellido());
            ps.setString(4, f.getEmail());
            ps.setString(5, f.getTelefono());
            ps.setString(6, f.getFechaIngreso());
            ps.executeUpdate();
        }
    }

    // ── ACTUALIZAR ────────────────────────────────────
    public void actualizar(Funcionario f) throws Exception {
        String sql = "UPDATE funcionario SET cedula=?, nombre=?, apellido=?, email=?, telefono=?, fecha_ingreso=? "+
                     "WHERE id_funcionario=?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, f.getCedula());
            ps.setString(2, f.getNombre());
            ps.setString(3, f.getApellido());
            ps.setString(4, f.getEmail());
            ps.setString(5, f.getTelefono());
            ps.setString(6, f.getFechaIngreso());
            ps.setInt(7, f.getId());
            ps.executeUpdate();
        }
    }

    // ── ELIMINAR ──────────────────────────────────────
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM funcionario WHERE id_funcionario=?";
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}

