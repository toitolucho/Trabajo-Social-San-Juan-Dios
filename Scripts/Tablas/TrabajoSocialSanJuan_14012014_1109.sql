
DROP TABLE historia_clinico_consulta_detalle;
DROP TABLE consulta;
DROP TABLE historia_clinico;
DROP TABLE propiedades_historial_clinico;
DROP TABLE propiedades_tipos;

DROP TABLE informe_psicologico;
DROP TABLE informes_detalle;
DROP TABLE informes;
DROP TABLE egresos;
DROP TABLE proveedores;
DROP TABLE ingresos;
DROP TABLE ingresos_tipos;
DROP TABLE Partidas;
DROP TABLE menus_comidas_detalle;
DROP TABLE menus_comidas;
DROP TABLE comidas;
DROP TABLE categorias_comidas;
DROP TABLE Personas_Kardex_Familiares;
DROP TABLE Personas_Kardex_Documentos;
DROP TABLE Documentos;
DROP TABLE Parentescos;
DROP TABLE Personas_Kardex;
DROP TABLE Usuarios;
DROP TABLE Personas_Datos_Nacimiento;
DROP TABLE Personas;
DROP TABLE Lugares;
DROP TABLE Provincias;
DROP TABLE Departamentos;
DROP TABLE Paises;
DROP TABLE Instituciones;
DROP TABLE Empleos;


CREATE TABLE Empleos
(
	codigo_empleo	SERIAL	NOT NULL,
	nombre_empleo	VARCHAR(200) NOT NULL UNIQUE,
	descripcion	VARCHAR(200) NULL,	
	CONSTRAINT PK_Empleos PRIMARY KEY(codigo_empleo)	
);

CREATE TABLE Instituciones
(
	codigo_institucion	SERIAL NOT NULL,
	nombre_institucion	VARCHAR(200) NOT NULL UNIQUE,
	direccion		VARCHAR(100) NULL,
	telefono		CHAR(10)     NULL,
	descripcion		VARCHAR(200) NULL,
	CONSTRAINT PK_Instituciones	PRIMARY KEY (codigo_institucion)
);

CREATE TABLE Paises
(
	codigo_pais	CHAR(2)		NOT NULL,
	nombre_pais	VARCHAR(250)	NOT NULL UNIQUE,
	nacionalidad	VARCHAR(250)	NULL,
	CONSTRAINT PK_Paises PRIMARY KEY(codigo_pais)
);


CREATE TABLE Departamentos
(
	codigo_pais		CHAR(2)		NOT NULL,
	codigo_departamento	CHAR(2)		NOT NULL,
	nombre_departamento	VARCHAR(250)	NOT NULL,
	CONSTRAINT PK_Departamentos PRIMARY KEY (codigo_pais, codigo_departamento),
	CONSTRAINT FK_Departamentos_Paises FOREIGN KEY (codigo_pais) 
	REFERENCES Paises(codigo_pais)

);


CREATE TABLE Provincias
(
	codigo_pais		CHAR(2)		NOT NULL,
	codigo_departamento	CHAR(2)		NOT NULL,
	codigo_provincia	CHAR(2)		NOT NULL,
	nombre_provincia	VARCHAR(250)	NOT NULL,
	CONSTRAINT PK_Provincias PRIMARY KEY (codigo_pais, codigo_departamento, codigo_provincia),
	CONSTRAINT FK_Provincias_Departamentos FOREIGN KEY (codigo_pais, codigo_departamento) 
	REFERENCES Departamentos(codigo_pais, codigo_departamento)
);

CREATE TABLE Lugares
(
	codigo_pais		CHAR(2)		NOT NULL,
	codigo_departamento	CHAR(2)		NOT NULL,
	codigo_provincia	CHAR(2)		NOT NULL,
	codigo_lugar		CHAR(3)		NOT NULL,
	nombre_lugar		VARCHAR(250)	NOT NULL,
	CONSTRAINT PK_Lugares PRIMARY KEY(codigo_pais, codigo_departamento, codigo_provincia, codigo_lugar),
	CONSTRAINT FK_Lugares_Provincias FOREIGN KEY (codigo_pais, codigo_departamento, codigo_provincia) 
	REFERENCES Provincias(codigo_pais, codigo_Departamento, codigo_provincia)
);

CREATE TABLE Personas
(
	codigo_persona		SERIAL		NOT NULL,
        di_persona              CHAR(10) 	NULL,--DOCUMENTO IDENTIFICADOR PERSONAS(CI, NRO PASAPORTE, ETC)
        paterno                 VARCHAR(40)	NOT NULL,
        materno                 VARCHAR(40)	NULL,
        nombres                 VARCHAR(80)	NOT NULL,	
        codigo_Tipo_persona	CHAR(1)		NOT NULL,
        codigo_empleo		INT NULL, 
        grado_instruccion       CHAR(1)         NULL,
        sexo                    CHAR(1) DEFAULT 'F' NOT NULL,
        estado_civil            CHAR(1) DEFAULT 'S' NOT NULL,
        celular                 CHAR(10)	NULL,
        telefono                VARCHAR(100)	NULL,
        domicilio 		TEXT		NULL,
        observaciones           TEXT		NULL,
	CONSTRAINT PK_Personas	PRIMARY KEY(codigo_persona),
	CONSTRAINT CH_Tipo_persona CHECK(codigo_Tipo_persona IN ('N','F','U','O','R','A')),--'N'->NIÑO, 'R'->FUNCIONARIO, 'F'->FAMILIARES, 'A'->APODERADOS, 'U'->USUARIO, 'O'->OTROS
	CONSTRAINT CH_Sexo CHECK(sexo IN('F', 'M')),
	CONSTRAINT CH_Estado_civil CHECK(estado_civil IN('C', 'D', 'V', 'S')),
	CONSTRAINT CH_grado_instruccion CHECK (grado_instruccion IN ('A','P','S','U','T','R','N')), --'N'->NINGUNO, 'A'->ANALFABETO, 'P'->PRIMARIO, 'S'->SECUNDARIO, 'U'->UNIVERSITARIO, 'T'->TECNICO SUPERIOR, 'R'->SUPERIOR    --GRADO INSTRUCCIÓN
	CONSTRAINT FK_Personas_Empleos FOREIGN KEY (codigo_empleo) REFERENCES Empleos(codigo_empleo)
);

-- CREATE TABLE Personas_Datos_Domicilio
-- (
--         codigo_persona          INT 	NOT NULL,
--         codigo_paisD            INT	NULL,
--         codigo_departamentoD    INT	NULL,
--         codigo_provinciaD	INT	NULL,
--         codigo_lugarD           INT	NULL,
--         direccionD              CHAR(150)NOT NULL,
--         telefonoD               CHAR(15) NOT NULL,
--         faxD                    CHAR(15) NULL,
--         casillaD                CHAR(10) NULL,
--         observaciones           TEXT	NULL,
--         CONSTRAINT PK_PersonasDatosDomicilio PRIMARY KEY (codigo_persona),
--         CONSTRAINT FK_PersonasDatosDomicilio_Personas FOREIGN KEY (codigo_persona) REFERENCES Personas(codigo_persona),        
--         CONSTRAINT FK_PersonasDatosDomicilio_Lugares FOREIGN KEY (codigo_paisD, codigo_departamentoD, codigo_provinciaD, codigo_lugarD)
--         REFERENCES Lugares(codigo_pais, codigo_departamento, codigo_provincia, codigo_lugar)
-- );

CREATE TABLE Personas_Datos_Nacimiento
(
        codigo_persona		INT	 NOT NULL,
        fecha_nacimiento        DATE	 NOT NULL CHECK(fecha_nacimiento <= NOW()::DATE),
        Edad			INT	 NULL,
        codigo_paisN            CHAR(2)	 NOT NULL,
        codigo_departamentoN    CHAR(2)	 NULL,
        codigo_provinciaN       CHAR(2)  NULL,
        codigo_lugarN           CHAR(3)  NULL,
        codigo_nacionalidad     CHAR(2)  NULL,
        observaciones           TEXT NULL,
        CONSTRAINT PK_PersonasDatosNacimiento PRIMARY KEY(codigo_persona),
        CONSTRAINT FK_PersonasDatosNacimiento_Personas FOREIGN KEY (codigo_persona) REFERENCES Personas(codigo_persona),
        CONSTRAINT FK_PersonasDatosNacimiento_Paises_Nacionalidad FOREIGN KEY (codigo_nacionalidad) REFERENCES Paises(codigo_pais),
        CONSTRAINT FK_PersonasDatosNacimiento_Lugares FOREIGN KEY (codigo_paisN,codigo_departamentoN, codigo_provinciaN, codigo_lugarN)
        REFERENCES Lugares(codigo_pais, codigo_departamento, codigo_provincia, codigo_lugar)
);

CREATE TABLE Usuarios
(
	codigo_usuario		SERIAL NOT NULL,
	codigo_persona		INT NOT NULL,
	fecha_registro		DATE DEFAULT NOW(),
	nombre_usuario	varchar(200) UNIQUE NOT NULL,
	contrasenia	VARCHAR(100) NOT NULL,
	codigo_tipo	CHAR(1)	NOT NULL CHECK(codigo_tipo IN ('S','M','V','A','D','P')),--'S':Secretaria,'M':Medico,'V':Visitadora Social,'A':Administrador, 'D':Directora del Hogar,'P':'Psicologa'
	codigo_institucion	INT  NULL, --Institución en la que se registra el usuario
	CONSTRAINT PK_Usuarios PRIMARY KEY(codigo_usuario),
        CONSTRAINT FK_Usuarios_Personas FOREIGN KEY (codigo_persona) REFERENCES Personas(codigo_persona),
        CONSTRAINT FK_Usuarios_instituciones FOREIGN KEY (codigo_institucion) REFERENCES instituciones(codigo_institucion)
);

CREATE TABLE Personas_Kardex
(
	codigo_kardex		SERIAL NOT NULL,	 --PROPIO DEL SISTEMA
	numero_kardex		INT NOT NULL,	 --NUMERO DE FICHA DE KARDEX MANEJADO POR LA INSTITUCIÓN
	codigo_persona		INT NOT NULL,
	fecha_registro		DATE DEFAULT NOW(),
	fecha_ingreso		DATE DEFAULT NOW(),
	fecha_egreso 		DATE NULL,
	centro 			TEXT NULL,
	motivo_ingreso 		TEXT NULL,
	codigo_persona_ingreso 	INT NULL,-- Persona que refirió el caso!		
	motivo_egreso 		TEXT NULL,
	codigo_persona_egreso	INT  NULL, --persona que es responsable del egreso
	codigo_persona_trab_social INT NULL,-- TRABAJADORA SOCIAL QUE AUTORIZA LA SALIDA
	nombre_kardex 		TEXT NULL,
	codigo_usuario 		INTEGER NOT NULL, -- USUARIO QUE REALIZA EL REGISTRO
	codigo_institucion	INT  NULL, --Institución en la que se registra el niño
	ruta_archivo_foto	TEXT NULL,
	codigo_estado		CHAR(1), --A->ALTA 'B'->BAJA
	CONSTRAINT PK_Personas_Ficha_Kardex PRIMARY KEY (codigo_kardex),
	CONSTRAINT U_numero_kardex UNIQUE(codigo_persona),
	CONSTRAINT FK_Personas_Kardex_Personas01 FOREIGN KEY (codigo_persona) REFERENCES Personas(codigo_persona),
	CONSTRAINT FK_Personas_Kardex_Personas02 FOREIGN KEY (codigo_persona_egreso) REFERENCES Personas(codigo_persona),
	CONSTRAINT FK_Personas_Kardex_Personas03 FOREIGN KEY (codigo_persona_trab_social) REFERENCES Personas(codigo_persona),
	CONSTRAINT FK_Personas_Kardex_Usuarios FOREIGN KEY (codigo_usuario) REFERENCES Usuarios(codigo_usuario),
	CONSTRAINT FK_Personas_Kardex_instituciones FOREIGN KEY (codigo_institucion) REFERENCES instituciones(codigo_institucion)
);
-- 
-- CREATE TABLE personas_historial_clinico
-- (
-- 	codigo_kardex	int,
-- 	grupo_sanguineo	varchar(10),
-- 	fecha_apertura	date,
-- 	fecha_registro	date,
-- 	observaciones	text,
-- 	CONSTRAINT PK_personas_historial_clinico PRIMARY KEY (codigo_kardex),
-- 	CONSTRAINT FK_personas_historial_clinico_kardex	FOREIGN KEY(codigo_kardex) REFERENCES Personas_Kardex(codigo_kardex)
-- );



CREATE TABLE Parentescos
(
	codigo_parentesco    SERIAL NOT NULL,
	nombre_parentesco    VARCHAR(100)   NOT NULL,
	Descripcion          VARCHAR(300)   NULL,
	CONSTRAINT FK_Parentescos PRIMARY KEY(codigo_parentesco),
	CONSTRAINT CH_NombreParentesco UNIQUE(nombre_parentesco)
);


CREATE TABLE Documentos
(
	codigo_documento  SERIAL NOT NULL,
	nombre_documento  VARCHAR(150) NOT NULL,
	Descripcion      VARCHAR(300) NULL,
	CONSTRAINT PK_Documentos PRIMARY KEY(codigo_documento),
	CONSTRAINT CH_Nombre_Documento UNIQUE(nombre_documento)
);


CREATE TABLE Personas_Kardex_Documentos
(
	codigo_kardex       	INT     NOT NULL,
	codigo_documento	INT     NOT NULL,		
	fecha_registro       	DATE  	NULL DEFAULT NOW(),
	tramito_trab_social   CHAR(1)   NOT NULL,
	
	CONSTRAINT PK_Personas_Kardex_Documentos PRIMARY KEY (codigo_kardex, codigo_documento),
	CONSTRAINT FK_Personas_Kardex_01 FOREIGN KEY (codigo_kardex) REFERENCES Personas_Kardex (codigo_kardex),
	CONSTRAINT FK_Personas_Kardex_Documentos01 FOREIGN KEY (codigo_documento) REFERENCES Documentos (codigo_documento),
	CONSTRAINT ch_tramito_trab_social CHECK(tramito_trab_social IN ('S','N'))-->'S'->SI,'N'->NO
);



CREATE TABLE Personas_Kardex_Familiares
(
	codigo_kardex   	INT     NOT NULL,
	codigo_persona		INT	NOT NULL,
	codigo_parentesco	INT	NOT NULL,
	monto_ingreso		FLOAT	NULL DEFAULT 0,
	fecha_registro		DATE	NULL DEFAULT NOW(),
	observaciones		TEXT	NULL,
	CONSTRAINT PK_Personas_Kardex_Familiares PRIMARY KEY (codigo_kardex, codigo_persona),
	CONSTRAINT FK_Personas_Kardex_Familiares_Personas FOREIGN KEY (codigo_persona) REFERENCES Personas(codigo_persona),
	CONSTRAINT FK_Personas_Kardex_Familiares_Parentescos FOREIGN KEY (codigo_parentesco) REFERENCES Parentescos(codigo_parentesco),
	CONSTRAINT CH_monto_ingreso_familiar CHECK (monto_ingreso >= 0)
	
);

CREATE TABLE categorias_comidas
(
	codigo_categoria	SERIAL,
	nombre_categoria	VARCHAR(200),
	orden_categoria		INT NOT NULL,
	estado_categoria	CHAR(1) NOT NULL DEFAULT 'A',
	descripcion		TEXT,
	hora_inicio		TIME,
	hora_fin		TIME,
	CONSTRAINT PK_Categoria_comida PRIMARY KEY (codigo_categoria),
	CONSTRAINT U_nombre_categoria_comida UNIQUE(nombre_categoria),
	CONSTRAINT CH_estado_categoria_comida CHECK(estado_categoria IN ('A', 'B'))-- 'A'->ALTA, 'B'-> BAJA
);

CREATE TABLE comidas
(
	codigo_comida		SERIAL,
	nombre_comida		VARCHAR(250) NOT NULL,
	codigo_categoria	INT NULL,
	precio_estimado		FLOAT DEFAULT 0,			
	descripcion		TEXT NULL,
	CONSTRAINT PK_Comidas PRIMARY KEY (codigo_comida),
	CONSTRAINT U_nombre_comida UNIQUE(nombre_comida),
	CONSTRAINT CH_Precio_estimado_comida CHECK(precio_estimado >= 0)
);

CREATE TABLE menus_comidas
(
	codigo_menu_comida	SERIAL,
	nombre_menu		VARCHAR(250),
	fecha_inicio		DATE,
	fecha_fin		DATE,
	fecha_registro		DATE,
	codigo_usuario		INT,
	codigo_estado		CHAR(1),
	monto_total		FLOAT,
	observaciones		TEXT,
	CONSTRAINT PK_menus_comidas PRIMARY KEY(codigo_menu_comida),
	CONSTRAINT FK_menus_comidas_usuarios FOREIGN KEY (codigo_usuario) REFERENCES Usuarios (codigo_usuario),
	CONSTRAINT CH_Intervalo_fecha_fin_inicio CHECK(fecha_fin >= fecha_inicio)
);



CREATE TABLE menus_comidas_detalle
(
	codigo_menu_comida_detalle	SERIAL,
	codigo_menu_comida	INT,
	codigo_comida		INT,	
	codigo_categoria	INT,
	fecha			DATE,
	hora_inicio		TIME,
	hora_fin		TIME,
	cantidad_personas	INT,
	precio_unitario		FLOAT,
	CONSTRAINT PK_menus_comidas_detalle PRIMARY KEY (codigo_menu_comida_detalle),
	CONSTRAINT FK_menus_comidas_detalle01 FOREIGN KEY (codigo_menu_comida) REFERENCES menus_comidas(codigo_menu_comida),
	CONSTRAINT FK_menus_comidas_detalle02 FOREIGN KEY (codigo_comida) REFERENCES comidas(codigo_comida),
	CONSTRAINT FK_menus_comidas_detalle03 FOREIGN KEY (codigo_categoria) REFERENCES categorias_comidas(codigo_categoria),
	CONSTRAINT U_menu_comida_categoria_fecha UNIQUE (codigo_menu_comida, codigo_comida, codigo_categoria, fecha),
	CONSTRAINT CH_Intervalo_hora_fin_inicio CHECK(hora_fin >= hora_inicio),
	CONSTRAINT CH_cantidad_personas CHECK(cantidad_personas >= 0),
	CONSTRAINT CH_precio_unitario	CHECK(precio_unitario >= 0)
);

CREATE TABLE Partidas
(
	codigo_partida		CHAR(10)	NOT NULL,
	codigo_partida_padre	CHAR(10)	NULL,
	nombre_partida		VARCHAR(250)	NOT NULL,
	descripcion_partida	TEXT		NULL,
	CONSTRAINT PK_Partidas  PRIMARY KEY (codigo_partida),
	CONSTRAINT FK_Partida_padre FOREIGN KEY (codigo_partida_padre) REFERENCES Partidas(codigo_partida) 
	MATCH SIMPLE ON UPDATE NO ACTION ON DELETE CASCADE,
	CONSTRAINT U_Nombre_partida UNIQUE(nombre_partida)
);

CREATE TABLE ingresos_tipos
(
	codigo_ingreso_tipo   SERIAL NOT NULL,
	nombre_ingreso_tipo     VARCHAR(150) NOT NULL,
	Descripcion      VARCHAR(300) NULL,
	CONSTRAINT PK_ingresos_tipos PRIMARY KEY(codigo_ingreso_tipo),
	CONSTRAINT CH_nombre_ingreso_tipo UNIQUE(nombre_ingreso_tipo)
);

CREATE TABLE ingresos
(
	codigo_ingreso 	SERIAL,
	fecha_ingreso	DATE	NOT NULL DEFAULT NOW(),
	nombre_ingreso	VARCHAR(250) NULL,
	codigo_usuario  INT	NOT NULL,
	monto_ingreso	FLOAT  DEFAULT 0,
	monto_actual	FLOAT,
	codigo_ingreso_tipo INT NOT NULL,
	detalle_ingreso TEXT    NULL,
	CONSTRAINT PK_ingresos PRIMARY KEY (codigo_ingreso),	
	CONSTRAINT FK_codigo_ingreso_tipo FOREIGN KEY (codigo_ingreso_tipo) REFERENCES ingresos_tipos(codigo_ingreso_tipo),
	CONSTRAINT FK_ingresos_usuarios FOREIGN KEY (codigo_usuario) REFERENCES usuarios(codigo_usuario),
	CONSTRAINT CH_monto_actual_intervalo CHECK(monto_actual BETWEEN 0 AND monto_ingreso),
	CONSTRAINT U_nombre_ingreso UNIQUE(nombre_ingreso)
	
);


CREATE TABLE proveedores
(
	codigo_proveedor	SERIAL,
	nombre_proveedor	VARCHAR(200),
	estado_proveedor	CHAR(1),
	nit_proveedor		CHAR(15) NULL,
	descripcion 		TEXT,
	CONSTRAINT PK_proveedores PRIMARY KEY(codigo_proveedor),
	CONSTRAINT u_nombre_proveedor UNIQUE(nombre_proveedor)
);

CREATE TABLE egresos
(
	codigo_egreso	SERIAL,
	fecha_egreso	DATE NOT NULL,
	codigo_usuario  INT  NOT NULL,
	codigo_partida	CHAR(10)  NOT NULL,
	codigo_ingreso	INT  NOT NULL,
	fecha_registro  DATE DEFAULT NOW(),
	nro_factura	INT  NOT NULL,
	codigo_proveedor INT NOT NULL,
	monto_salida	FLOAT DEFAULT 0,
	observaciones	TEXT NULL,
	CONSTRAINT PK_salidas PRIMARY KEY (codigo_egreso),
	CONSTRAINT FK_salidas_usuarios FOREIGN KEY (codigo_usuario) REFERENCES usuarios(codigo_usuario),
	CONSTRAINT FK_salidas_partidas FOREIGN KEY (codigo_partida) REFERENCES partidas(codigo_partida),
	CONSTRAINT FK_salidas_ingresos FOREIGN KEY (codigo_ingreso) REFERENCES ingresos(codigo_ingreso),
	CONSTRAINT FK_salidas_proveedores FOREIGN KEY (codigo_proveedor) REFERENCES proveedores(codigo_proveedor),
	constraint CH_monto_salida CHECK(monto_salida >= 0)
);




CREATE TABLE informes
(
	codigo_informe		SERIAL,
	codigo_kardex		INT,
	codigo_institucion	INT,
	codigo_tipo_informe	CHAR(1),
	codigo_persona_dirigido	INT,
	codigo_persona_via	INT,
	codigo_persona_de_01	INT,
	codigo_persona_de_02	INT,
	codigo_persona_de_03	INT,
	referencia		TEXT,
	fecha_registro		DATE  DEFAULT NOW(),
	fecha_envio		DATE,
	diagnostico		TEXT,
	sugerencias		TEXT,
	CONSTRAINT PK_informes PRIMARY KEY (codigo_informe),
	CONSTRAINT FK_informes_instituciones	FOREIGN KEY (codigo_institucion) REFERENCES instituciones(codigo_institucion),
	CONSTRAINT FK_informes_personas_01	FOREIGN KEY (codigo_persona_dirigido) REFERENCES personas(codigo_persona),
	CONSTRAINT FK_informes_personas_02	FOREIGN KEY (codigo_persona_via) REFERENCES personas(codigo_persona),
	CONSTRAINT FK_informes_personas_03	FOREIGN KEY (codigo_persona_de_01) REFERENCES personas(codigo_persona),
	CONSTRAINT FK_informes_personas_04	FOREIGN KEY (codigo_persona_de_02) REFERENCES personas(codigo_persona),
	CONSTRAINT FK_informes_personas_05	FOREIGN KEY (codigo_persona_de_03) REFERENCES personas(codigo_persona),
	CONSTRAINT FK_informes_personas_kardex	FOREIGN KEY (codigo_kardex) REFERENCES personas_kardex(codigo_kardex),
	CONSTRAINT CH_informes_codigo_tipo_informe CHECK(codigo_tipo_informe IN('A','B','C','D','E','F','G','O'))
);

CREATE TABLE informes_detalle
(
	codigo_informe		INT,
	referencia_caso		TEXT,
	fecha_inicio		DATE,
	fecha_fin		DATE,
	situacion_habitacional	TEXT,
	integracion_familiar	TEXT,
	desarrollo_afectivo	TEXT,

	historia_social		TEXT,
	situacion_actual	TEXT,
	fuentes_informacion	TEXT,

	descripcion_caso	TEXT, 
	documentos_adjuntos	TEXT,
	CONSTRAINT PK_informes_detalle PRIMARY KEY (codigo_informe),
	CONSTRAINT FK_informes_detalle_informe FOREIGN KEY (codigo_informe)  REFERENCES informes( codigo_informe)
);


CREATE TABLE informe_psicologico
(
	codigo_informe_psico	SERIAL,
	codigo_kardex		INT,
	motivo_consulta		TEXT,
	fecha_evaluacion	DATE DEFAULT NOW()::DATE,
	codigo_persona_evalua	INT,
	instrumentos		TEXT,
	antecedentes		TEXT,
	aspectos_relevantes	TEXT,
	conductas_observadas	TEXT,
	res_motricidad_gruesa	TEXT,
	res_motricidad_fino	TEXT,
	res_audicion_lenguaje	TEXT,
	res_personal_social	TEXT,
	res_total		TEXT,
	diagnostico		TEXT,
	recomendaciones		TEXT,
	CONSTRAINT PK_informe_psicologico PRIMARY KEY (codigo_informe_psico),
	CONSTRAINT FK_informe_psicologico_personas_kardex	FOREIGN KEY (codigo_kardex) REFERENCES personas_kardex(codigo_kardex),
	CONSTRAINT FK_informe_psicologico_personas FOREIGN KEY  (codigo_persona_evalua) REFERENCES personas(codigo_persona)
);

--TABLAS QUE REPRESENTA  A LOS TIPOS, vacunas, alergias, medicamnetos, laboratorios, enfermedades
CREATE TABLE propiedades_tipos
(
	numero_propiedad_tipo	SERIAL,
	nombre_propiedad_tipo	VARCHAR(200) UNIQUE,
	descripcion		TEXT,
	CONSTRAINT pk_propiedades_tipos PRIMARY KEY(numero_propiedad_tipo)
);

--TABLA QUE REPRESENTA CADA UNO DE LOS TIPOS DESCRITOS EN LA ANTERIOR TABLA -> Medicamentos : Diclofenaco, Antigripal, Tosalcos, etc.   Enfermedades: Resfrio, Temperatura, Tos,etc
CREATE TABLE propiedades_historial_clinico
(
	numero_propiedad		SERIAL,
	numero_propiedad_tipo	INT,
	nombre_propiedad		VARCHAR(150),
	abreviacion				VARCHAR(100),
	composicion				VARCHAR(200),
	descripcion				TEXT,
	CONSTRAINT PK_propiedades_historial_clinico PRIMARY KEY(numero_propiedad),
	CONSTRAINT FK_propiedades_historial_clinico_tipos FOREIGN KEY (numero_propiedad_tipo) REFERENCES propiedades_tipos(numero_propiedad_tipo),
	CONSTRAINT U_propiedad_hc_tipo UNIQUE (nombre_propiedad, numero_propiedad_tipo)
	
);

CREATE TABLE historia_clinico
(
	numero_hc	SERIAL,
	idpersona	INT,
	grupo_sanguinio		VARCHAR(10),
	fecha_registro		DATE DEFAULT NOW(),	
	CONSTRAINT pk_historia_clinica PRIMARY KEY(numero_hc)
);

CREATE TABLE consulta
(
	numero_consulta			SERIAL,
	numero_hc				int				NOT NULL,
	motivo					VARCHAR(100)	NULL,
	fecha_consulta			DATE DEFAULT NOW(),
	codigo_tipo_consulta	CHAR(1),
	diagnostico				TEXT,
	observaciones			TEXT,
	CONSTRAINT PK_consulta	PRIMARY KEY(numero_consulta),
	CONSTRAINT FK_consulta_historial_clinico FOREIGN KEY (numero_hc) REFERENCES historia_clinico(numero_hc)
	
);

CREATE TABLE historia_clinico_consulta_detalle
(
	numero_hc_consulta_detalle	SERIAL,
	numero_hc				INT		NULL,
	numero_propiedad_tipo	INT		NOT NULL,
	numero_consulta			INT		NULL,
	numero_propiedad		INT		NOT NULL,
	fecha_registro			DATE DEFAULT NOW(),
	descripcion				TEXT,
	CONSTRAINT PK_historia_clinico_consulta_detalle PRIMARY KEY (numero_hc_consulta_detalle),
	CONSTRAINT FK_historia_clinico_consulta_detalle_hc FOREIGN KEY (numero_hc) REFERENCES historia_clinico(numero_hc),
	CONSTRAINT FK_historia_clinico_consulta_detalle_tipo FOREIGN KEY (numero_propiedad_tipo) REFERENCES propiedades_tipos(numero_propiedad_tipo),
	CONSTRAINT FK_historia_clinico_consulta_detalle_consulta FOREIGN KEY (numero_consulta) REFERENCES consulta(numero_consulta),
	CONSTRAINT FK_historia_clinico_consulta_detalle_propiedad FOREIGN KEY (numero_propiedad) REFERENCES propiedades_historial_clinico(numero_propiedad)
);