# 🏛️ Gestión de Funcionarios — CRUD con Patrón DAO en Java

## 📋 Descripción del Proyecto
Aplicación de escritorio desarrollada en Java que permite gestionar 
la información de funcionarios de una entidad mediante operaciones 
CRUD (Crear, Leer, Actualizar, Eliminar), implementando el patrón 
de diseño DAO (Data Access Object) y manejo de excepciones.

---

## 🎯 Objetivo
Implementar técnicas de programación orientada a objetos utilizando 
el patrón DAO y excepciones en Java, conectado a una base de datos 
relacional en SQL Server.

---

## 🛠️ Tecnologías utilizadas
- Java JDK 21
- NetBeans IDE
- SQL Server Express 2022
- SQL Server Management Studio (SSMS)
- JDBC Driver para SQL Server

---

## 📁 Estructura del Proyecto


* GestionFuncionarios/
  * src/
    * dao/
        * ConexionBD.java  ← Conexión a SQL Server
        * FuncionarioDAO.java   ← Operaciones CRUD
     * modelo/
         * Funcionario.java      ← Clase modelo
     * vista/
         * VentanaPrincipal.java ← Interfaz gráfica
      
  ---

  ---

## 🗄️ Modelo Relacional
El sistema cuenta con las siguientes tablas:

- **departamento** (id_departamento, nombre_departamento)
- **cargo** (id_cargo, nombre_cargo, salario_base)
- **funcionario** (id_funcionario, cedula, nombre, apellido, 
  email, telefono, fecha_ingreso, id_departamento, id_cargo)

---

## ⚙️ Funcionalidades
- ✅ Listar todos los funcionarios
- ✅ Crear nuevo funcionario
- ✅ Editar funcionario existente
- ✅ Eliminar funcionario

---

## 🚀 ¿Cómo ejecutar el proyecto?

### 1. Requisitos previos
- Tener instalado Java JDK 21
- Tener instalado NetBeans
- Tener instalado SQL Server Express
- Tener instalado el driver JDBC para SQL Server

### 2. Base de datos
Ejecutar en SQL Server Management Studio:
```sql
CREATE DATABASE gestion_funcionarios;

USE gestion_funcionarios;

CREATE TABLE departamento (
    id_departamento INT IDENTITY(1,1) PRIMARY KEY,
    nombre_departamento VARCHAR(100) NOT NULL
);

CREATE TABLE cargo (
    id_cargo INT IDENTITY(1,1) PRIMARY KEY,
    nombre_cargo VARCHAR(100) NOT NULL,
    salario_base DECIMAL(10,2) NOT NULL
);

CREATE TABLE funcionario (
    id_funcionario INT IDENTITY(1,1) PRIMARY KEY,
    cedula VARCHAR(20) NOT NULL UNIQUE,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(150),
    telefono VARCHAR(20),
    fecha_ingreso DATE NOT NULL,
    id_departamento INT REFERENCES departamento(id_departamento),
    id_cargo INT REFERENCES cargo(id_cargo)
);
```

### 3. Configurar la conexión
En `ConexionBD.java` ajusta el puerto y credenciales:
```java
private static final String URL =
    "jdbc:sqlserver://localhost:TUPORT;" +
    "databaseName=gestion_funcionarios;" +
    "encrypt=true;" +
    "trustServerCertificate=true;";

private static final String USUARIO = "sa";
private static final String CONTRASENA = "TuContraseña";
```

### 4. Ejecutar
- Abrir el proyecto en NetBeans
- Agregar el driver JDBC en Libraries
- Presionar F6 para ejecutar

---

## 📌 Patrón DAO
El patrón DAO separa la lógica de acceso a datos de la lógica 
de negocio de la aplicación:

- **Modelo:** representa los datos (Funcionario.java)
- **DAO:** accede a la base de datos (FuncionarioDAO.java)
- **Vista:** interfaz gráfica (VentanaPrincipal.java)
- **Conexión:** gestiona la conexión a SQL Server (ConexionBD.java)

---

## 📝 Conclusiones
1. La implementación del patrón DAO permitió separar de forma clara 
la lógica de acceso a datos de la lógica de la aplicación, logrando 
un código organizado y mantenible.

2. El manejo de excepciones en Java fue fundamental para garantizar 
la estabilidad de la aplicación, capturando errores de conexión y 
operaciones de base de datos.

3. La integración de Java con SQL Server mediante JDBC demostró ser 
una solución eficiente para la persistencia de datos, cumpliendo con 
todos los requerimientos funcionales del caso de estudio.

---

## 👩‍💻 Autor
Juan Camilo Vitola — 2026
