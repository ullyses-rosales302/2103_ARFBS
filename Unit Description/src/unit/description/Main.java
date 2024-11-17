package unit.description;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<UnitDescription> units = new ArrayList<>();
    private static JPanel unitsPanel;

    public static void main(String[] args) {
        // Initialize frame
        JFrame frame = new JFrame("Apartment Rentals and Billing System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        
        // Set light theme
        UIManager.put("Panel.background", Color.WHITE);

        // Fonts
        Font headerFont = new Font("Arial", Font.BOLD, 18);
        Font bodyFont = new Font("Arial", Font.PLAIN, 14);

        // Main container
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(20, 20));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        ));

        // GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Form fields
        JLabel lblUnitID = new JLabel("Unit ID:");
        lblUnitID.setFont(bodyFont);
        JTextField fieldUnitID = new JTextField(15);

        JLabel lblCapacity = new JLabel("Capacity:");
        lblCapacity.setFont(bodyFont);
        JTextField fieldCapacity = new JTextField(15);

        JLabel lblUnitType = new JLabel("Unit Type:");
        lblUnitType.setFont(bodyFont);
        String[] unitTypes = {"ONE_BEDROOM", "TWO_BEDROOM", "STUDIO", "THREE_BEDROOM"};
        JComboBox<String> comboUnitType = new JComboBox<>(unitTypes);

        JLabel lblRent = new JLabel("Rent Amount:");
        lblRent.setFont(bodyFont);
        JTextField fieldRent = new JTextField(15);

        JLabel lblStatus = new JLabel("Status:");
        lblStatus.setFont(bodyFont);
        JTextField fieldStatus = new JTextField(15);

        // Add fields to form
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(lblUnitID, gbc);
        gbc.gridx = 1;
        formPanel.add(fieldUnitID, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(lblCapacity, gbc);
        gbc.gridx = 1;
        formPanel.add(fieldCapacity, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(lblUnitType, gbc);
        gbc.gridx = 1;
        formPanel.add(comboUnitType, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(lblRent, gbc);
        gbc.gridx = 1;
        formPanel.add(fieldRent, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        formPanel.add(lblStatus, gbc);
        gbc.gridx = 1;
        formPanel.add(fieldStatus, gbc);

        // Buttons
        JButton btnAddUnit = new JButton("Add Unit");
        btnAddUnit.setFont(headerFont);
        btnAddUnit.setBackground(new Color(173, 216, 230)); // Light blue
        btnAddUnit.setForeground(Color.BLACK);
        btnAddUnit.setFocusPainted(false);
        btnAddUnit.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JButton btnShowUnits = new JButton("Show All Units");
        btnShowUnits.setFont(headerFont);
        btnShowUnits.setBackground(new Color(173, 216, 230)); // Light blue
        btnShowUnits.setForeground(Color.BLACK);
        btnShowUnits.setFocusPainted(false);
        btnShowUnits.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(btnAddUnit);
        buttonPanel.add(btnShowUnits);

        // Units display panel
        unitsPanel = new JPanel();
        unitsPanel.setLayout(new BoxLayout(unitsPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(unitsPanel);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Units Overview"));

        // Add components to main panel
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(scrollPane, BorderLayout.SOUTH);

        // Add main panel to frame
        frame.getContentPane().add(mainPanel);
        frame.setVisible(true);

        // Button actions
        btnAddUnit.addActionListener((ActionEvent e) -> {
            try {
                int unitID = Integer.parseInt(fieldUnitID.getText());
                int capacity = Integer.parseInt(fieldCapacity.getText());
                String unitType = comboUnitType.getSelectedItem().toString();
                double rentAmount = Double.parseDouble(fieldRent.getText());
                String status = fieldStatus.getText().toUpperCase().replace(" ", "_");

                UnitDescription.UnitType type = UnitDescription.UnitType.valueOf(unitType);
                UnitDescription.UnitStatus unitStatus = UnitDescription.UnitStatus.valueOf(status);

                UnitDescription unit = new UnitDescription(unitID, capacity, type, 1, rentAmount, unitStatus);
                units.add(unit);

                JOptionPane.showMessageDialog(frame, "Unit added successfully!");
                fieldUnitID.setText("");
                fieldCapacity.setText("");
                fieldRent.setText("");
                fieldStatus.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
            }
        });

        btnShowUnits.addActionListener((ActionEvent e) -> {
            unitsPanel.removeAll();
            for (UnitDescription unit : units) {
                JPanel unitCard = createUnitCard(unit, bodyFont);
                unitsPanel.add(unitCard);
            }
            unitsPanel.revalidate();
            unitsPanel.repaint();
        });
    }

    private static JPanel createUnitCard(UnitDescription unit, Font bodyFont) {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout(10, 10));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200), 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        JLabel lblTitle = new JLabel("Unit " + unit.getUnitID());
        lblTitle.setFont(bodyFont);

        JLabel lblInfo = new JLabel("<html>Capacity: " + unit.getCapacity() + "<br/>Rent: $" + unit.getRentAmount() + "<br/>Status: " + unit.getStatus() + "</html>");
        lblInfo.setFont(bodyFont);

        card.add(lblTitle, BorderLayout.NORTH);
        card.add(lblInfo, BorderLayout.CENTER);

        return card;
    }
}