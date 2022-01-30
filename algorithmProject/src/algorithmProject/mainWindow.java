package algorithmProject;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.Color;

public class mainWindow {

	private JFrame frame;
	private JTextField textField;
	private JTextField txtMean;
	private JTextField txtMedian;
	private JTextField txtVariance;
	private JTextField textShow;
	public JTextField textSort;
	public JTextField textSearch;
	
	ArrayList<String> arr = new ArrayList<String>();
	
	NumberFormat formatter = new DecimalFormat("#0.00");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainWindow window = new mainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainWindow() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1041, 569);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textField.setBounds(142, 159, 334, 33);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		txtMean = new JTextField();
		txtMean.setBounds(740, 270, 110, 24);
		frame.getContentPane().add(txtMean);
		txtMean.setColumns(10);
		
		txtMedian = new JTextField();
		txtMedian.setBounds(740, 324, 110, 24);
		frame.getContentPane().add(txtMedian);
		txtMedian.setColumns(10);
		
		txtVariance = new JTextField();
		txtVariance.setBounds(740, 380, 110, 24);
		frame.getContentPane().add(txtVariance);
		txtVariance.setColumns(10);
		
		textShow = new JTextField();
		textShow.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textShow.setHorizontalAlignment(SwingConstants.LEFT);
		textShow.setEditable(false);
		textShow.setBounds(174, 266, 242, 29);
		frame.getContentPane().add(textShow);
		textShow.setColumns(10);
		
		textSort = new JTextField();
		textSort.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		textSort.setEditable(false);
		textSort.setBounds(173, 366, 243, 29);
		frame.getContentPane().add(textSort);
		textSort.setColumns(10);
		
		textSearch = new JTextField();
		textSearch.setBounds(202, 447, 96, 29);
		frame.getContentPane().add(textSearch);
		textSearch.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setForeground(new Color(224, 255, 255));
		btnAdd.setBackground(new Color(0, 0, 128));
		btnAdd.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arr.add(textField.getText());
				try {
					event();
				}
				catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Only accept numbers", "Type Error!", JOptionPane.INFORMATION_MESSAGE);
					textField.setText(null);
					arr.remove(arr.size()-1);
				}
			}
		});
		btnAdd.setBounds(513, 157, 96, 34);
		frame.getContentPane().add(btnAdd);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnClear.setForeground(new Color(224, 255, 255));
		btnClear.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnClear.setBackground(new Color(0, 0, 128));
		btnClear.setBounds(647, 157, 96, 34);
		frame.getContentPane().add(btnClear);
		
		Icon icon = new ImageIcon("src\\algorithmProject\\images\\undo.png");
		Image undoImg = ((ImageIcon) icon).getImage().getScaledInstance(28, 28, Image.SCALE_DEFAULT);
		
		JButton btnRemove = new JButton(new ImageIcon(undoImg));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					arr.remove(arr.size()-1);
					event();
				}
				catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "No data in the Array List", "Empty List!", JOptionPane.INFORMATION_MESSAGE);
					clear();
				}
			}
		});
		btnRemove.setForeground(new Color(224, 255, 255));
		btnRemove.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnRemove.setBackground(Color.ORANGE);
		btnRemove.setBounds(776, 158, 63, 34);
		frame.getContentPane().add(btnRemove);
		
		JLabel SearchResult = new JLabel("");
		SearchResult.setFont(new Font("Segoe UI", Font.BOLD, 14));
		SearchResult.setBounds(436, 442, 334, 34);
		frame.getContentPane().add(SearchResult);
		
		JButton btnBinary = new JButton("Try");
		btnBinary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int s = BinarySearch.binarySearch(MergeSort.sortedArray(arr), 0, MergeSort.sortedArray(arr).size() - 1, Double.parseDouble(textSearch.getText()));
					SearchResult.setText("The position is " + String.valueOf(s));
				}
				catch (Exception e3) {
					if (arr.isEmpty())
						JOptionPane.showMessageDialog(null, "No data in the Array List", "Empty List!", JOptionPane.INFORMATION_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "Please type a value to search the position", "No Entry!", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnBinary.setForeground(new Color(224, 255, 255));
		btnBinary.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnBinary.setBackground(new Color(0, 0, 128));
		btnBinary.setBounds(320, 442, 96, 34);
		frame.getContentPane().add(btnBinary);
		
		JLabel lblBinary = new JLabel("Search the position of ");
		lblBinary.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblBinary.setBounds(39, 442, 165, 34);
		frame.getContentPane().add(lblBinary);

		JLabel mean = new JLabel("Mean: ");
		mean.setFont(new Font("Segoe UI", Font.BOLD, 16));
		mean.setBounds(617, 264, 78, 29);
		frame.getContentPane().add(mean);
		
		JLabel median = new JLabel("Median:");
		median.setFont(new Font("Segoe UI", Font.BOLD, 16));
		median.setBounds(617, 326, 78, 13);
		frame.getContentPane().add(median);
		
		JLabel variance = new JLabel("Variance:");
		variance.setFont(new Font("Segoe UI", Font.BOLD, 16));
		variance.setBounds(617, 382, 78, 13);
		frame.getContentPane().add(variance);
		
		JLabel lblNewLabel = new JLabel("Raw Data");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setBounds(39, 262, 96, 34);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblSortedData = new JLabel("Sorted Data");
		lblSortedData.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSortedData.setBounds(39, 362, 115, 34);
		frame.getContentPane().add(lblSortedData);
		
		JLabel lblNewLabel_1 = new JLabel("Statistical Calculater");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 50));
		lblNewLabel_1.setBounds(265, 44, 488, 63);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBackground(new Color(230, 230, 250));
		lblNewLabel_2.setIcon(new ImageIcon("src\\algorithmProject\\images\\img2.jpeg"));
		lblNewLabel_2.setBounds(0, 0, 1027, 532);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		
		
		
		
		
		
	}
	
	void event() {
		textField.setText(null);
		MergeSort.sortedArray(arr);
		textShow.setText(arr.toString());
		textSort.setText(MergeSort.sortedArray(arr).toString());
		txtMean.setText(formatter.format(GFG.getMean(arr)).toString()); // mean
		txtMedian.setText(GFG.getMedian(MergeSort.sortedArray(arr)));
		txtVariance.setText(formatter.format(GFG.getVariance(arr)).toString()); // variance 
	}
	
	void clear() {
		arr.clear();
		textShow.setText(null);
		textSort.setText(null);
		txtMedian.setText(null);
		txtMean.setText(null);
		txtVariance.setText(null);
		textField.setText(null);
	}
}
