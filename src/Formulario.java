import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

public class Formulario extends JFrame implements ActionListener {

	private Container contenedor;
	private JLabel titulo, labelBusqueda, labelOrdenar, informacion, labelLimitar,labelNombre,labelFecha;
	private JTextField campoBusqueda;
	private JComboBox selectorOrdenar;
	private JRadioButton alMenosUno, todos, ascendente, descendente;
	private JButton botonBuscar, botonLimpiar;
	private JSpinner cantidad;
	private JTable resultados;
	private JScrollPane tableScroll;
	private String[] columnas = { "Nombre", "Apellido 1", "Apellido 2", "Poblacion" };
	private JLabel labelimagen;

	// Constructor
	public Formulario() {
		this.setTitle("Supuesto practico 8");
		this.setBounds(300, 100, 800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Esta parte siempre igual
		this.contenedor = this.getContentPane();
		this.contenedor.setLayout(null);

		// Titulo del formulario
		this.titulo = new JLabel("Ver alumnos");
		this.titulo.setFont(new Font("Arial", Font.PLAIN, 30));
		this.titulo.setBounds(50, 20, 300, 30);
		this.contenedor.add(this.titulo);

		// Label del campo busqueda
		this.labelBusqueda = new JLabel("Busqueda");
		this.labelBusqueda.setFont(new Font("Arial", Font.PLAIN, 20));
		this.labelBusqueda.setBounds(50, 60, 150, 20);
		this.contenedor.add(this.labelBusqueda);

		// Campo de busqueda
		this.campoBusqueda = new JTextField();
		this.campoBusqueda.setFont(new Font("Arial", Font.PLAIN, 15));
		this.campoBusqueda.addActionListener(this);
		this.campoBusqueda.setBounds(50, 90, 200, 20);
		this.contenedor.add(this.campoBusqueda);

		// Radio Buttons ascendente y descendente
		this.alMenosUno = new JRadioButton("Al menos uno");
		this.alMenosUno.setFont(new Font("Arial", Font.PLAIN, 15));
		this.alMenosUno.setBounds(50, 120, 120, 15);
		this.alMenosUno.setSelected(true);
		this.contenedor.add(this.alMenosUno);

		this.todos = new JRadioButton("Todos");
		this.todos.setFont(new Font("Arial", Font.PLAIN, 15));
		this.todos.setBounds(50, 140, 120, 15);
		this.contenedor.add(this.todos);

		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(this.alMenosUno);
		grupo1.add(this.todos);

		// Label del selecto ordenar
		this.labelOrdenar = new JLabel("Ordenar por campo");
		this.labelOrdenar.setFont(new Font("Arial", Font.PLAIN, 20));
		this.labelOrdenar.setBounds(50, 170, 200, 20);
		this.contenedor.add(this.labelOrdenar);
		
		// Label nombre
		this.labelNombre = new JLabel("Toñi Sanchez Maiquez");
		this.labelNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		this.labelNombre.setBounds(420, 130, 200, 20);
		this.contenedor.add(this.labelNombre);
		
		// Label fecha
		this.labelFecha = new JLabel("01/06/2023");
		this.labelFecha.setFont(new Font("Arial", Font.PLAIN, 15));
		this.labelFecha.setBounds(460, 150, 200, 20);
		this.contenedor.add(this.labelFecha);

		// Selector ordenar por campo
		this.selectorOrdenar = new JComboBox();
		this.selectorOrdenar.setFont(new Font("Arial", Font.PLAIN, 15));
		this.selectorOrdenar.setBounds(50, 200, 200, 20);
		this.selectorOrdenar.addItem("Nombre");
		this.selectorOrdenar.addItem("Apellido 1");
		this.selectorOrdenar.addItem("Apellido 2");
		this.selectorOrdenar.addItem("Poblacion");
		this.contenedor.add(this.selectorOrdenar);

		// Radio Buttons ascendente y descendente
		this.ascendente = new JRadioButton("Ascendente");
		this.ascendente.setFont(new Font("Arial", Font.PLAIN, 15));
		this.ascendente.setBounds(50, 230, 120, 15);
		this.ascendente.setSelected(true);
		this.contenedor.add(this.ascendente);

		this.descendente = new JRadioButton("Descendente");
		this.descendente.setFont(new Font("Arial", Font.PLAIN, 15));
		this.descendente.setBounds(170, 230, 120, 15);
		this.contenedor.add(this.descendente);

		ButtonGroup grupo2 = new ButtonGroup();
		grupo2.add(this.ascendente);
		grupo2.add(this.descendente);

		// Label del selecto ordenar
		this.labelLimitar = new JLabel("Limitar Cantidad Resultados");
		this.labelLimitar.setFont(new Font("Arial", Font.PLAIN, 20));
		this.labelLimitar.setBounds(50, 260, 250, 20);
		this.contenedor.add(this.labelLimitar);

		// Selector cantidad de resultados
		SpinnerModel model = new SpinnerNumberModel(100, 1, 1000, 1);
		this.cantidad = new JSpinner(model);
		this.cantidad.setBounds(50, 285, 100, 20);
		this.contenedor.add(this.cantidad);

		// Boton buscar
		this.botonBuscar = new JButton("Buscar");
		this.botonBuscar.setFont(new Font("Arial", Font.PLAIN, 15));
		this.botonBuscar.setBounds(50, 320, 90, 20);
		this.botonBuscar.addActionListener(this);
		this.contenedor.add(this.botonBuscar);

		// Boton Limpiar
		this.botonLimpiar = new JButton("Limpiar");
		this.botonLimpiar.setFont(new Font("Arial", Font.PLAIN, 15));
		this.botonLimpiar.setBounds(160, 320, 90, 20);
		this.botonLimpiar.addActionListener(this);
		this.contenedor.add(this.botonLimpiar);

		// Label de informacion
		this.informacion = new JLabel("");
		this.informacion.setFont(new Font("Arial", Font.PLAIN, 20));
		this.informacion.setBounds(170, 285, 450, 25);
		this.contenedor.add(this.informacion);

		// Inicializar tabla de resultados
		this.resultados = new JTable(new String[0][0], this.columnas);
		this.tableScroll = new JScrollPane(this.resultados);
		this.tableScroll.setBounds(50, 360, 680, 240);
		this.contenedor.add(this.tableScroll);

		// La ultima parte es hacer visible la ventana
		this.setVisible(true);
		
		
		//definir la imagen
		ImageIcon imagen = new ImageIcon("./assets/a.jpg");
		this.labelimagen = new JLabel();
		this.labelimagen.setBounds(350,0,305,165 );
		this.labelimagen.setIcon(imagen);
		this.contenedor.add(this.labelimagen);
		
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.botonBuscar  || e.getSource() == this.campoBusqueda) {
			String busqueda = this.campoBusqueda.getText().trim();
			String ordenar = this.cambiarNombresCamposBD();
			String ordenacion = "ASC";
			String cantidad = this.cantidad.getValue().toString();

			if (this.descendente.isSelected()) {
				ordenacion = "DESC";
			}
			String por = "AND";
			if (this.alMenosUno.isSelected()) {
				por = "OR";
			}

			DB conexion = new DB(); // Objeto de base de datos
			ArrayList<Alumno> listado = conexion.buscarAlumnos(busqueda, ordenar, ordenacion,cantidad,por);
			if (listado.size() == 0) {
				this.informacion.setText("No se han encontrado resultados...");
				this.resultados.setModel(new DefaultTableModel(new String[0][0], this.columnas));
			} else {
				this.informacion.setText("Se han encontrado " + listado.size() + " resultados.");

				this.setResultados(listado);
			}

		} else if (e.getSource() == this.botonLimpiar) {
			// Limpiar formulario y resultados
			this.clear();
		}
	}

	// MEtodo que se ejecuta al darle al boton limpiar
	private void clear() {
		this.campoBusqueda.setText("");
		this.informacion.setText("");
		this.resultados.setModel(new DefaultTableModel(new String[0][0], this.columnas));
	}

	// Metodo que
	private void setResultados(ArrayList<Alumno> listado) {
		String[][] datos = new String[listado.size()][this.columnas.length];
		for (int i = 0; i < listado.size(); i++) {
			Alumno actual = listado.get(i);
			datos[i][0] = actual.getNombre();
			datos[i][1] = actual.getApellido1();
			datos[i][2] = actual.getApellido2();
			datos[i][3] = actual.getpoblacion();
		}
		this.resultados.setModel(new DefaultTableModel(datos, this.columnas));
	}
	
	private String cambiarNombresCamposBD() {
		String campo = this.selectorOrdenar.getSelectedItem().toString();
				if(campo.equalsIgnoreCase("Apellido 1")) {
					return "apellido1";
				}else if(campo.equalsIgnoreCase("Apellido 2")) {
					return "apellido2";
				}
				return campo;
	}
}




