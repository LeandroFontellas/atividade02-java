package swing;

import javax.swing.*;

import entities.Livro;
import entities.Revista;
import tela.Tela;

import java.awt.event.*;
import java.util.List;
import java.awt.*;



public class LivroPainel extends JFrame implements ActionListener {

    private JButton incluirButton;
    private JButton listagemButton;
    private JButton revistasButton;
    private JLabel labelTitulo;
    private JTextField textFieldTitulo;
    private JLabel labelAutor;
    private JTextField textFieldAutor;
    private JLabel labelAno;
    private JTextField textFieldAno;
    private Tela tela;

  public LivroPainel(Tela tela) {
        super("Material Bibliográfico");
        
        this.tela = tela;
    
        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
         
        incluirButton = new JButton("Incluir");
        listagemButton = new JButton("Listagem");
        revistasButton = new JButton("Revistas");
        
        // Adicionando actionListener nos botoes
        incluirButton.addActionListener(this);
        listagemButton.addActionListener(this);
        revistasButton.addActionListener(this);

        labelTitulo = new JLabel("Titulo: ");
        textFieldTitulo = new JTextField(15);
        labelAutor = new JLabel("Autor: ");
        textFieldAutor = new JTextField(15);
        labelAno = new JLabel("Ano : ");
        textFieldAno = new JTextField(4);
        
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
         
        panel2.setBorder(BorderFactory.createTitledBorder("Livros"));
         
        BoxLayout layout3 = new BoxLayout(panel3, BoxLayout.Y_AXIS);
        BoxLayout layout2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
        BoxLayout layout = new BoxLayout(panel, BoxLayout.X_AXIS);
        
        panel.setLayout(layout);
        panel2.setLayout(layout2);
        panel3.setLayout(layout3);
         
        incluirButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        listagemButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        textFieldTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        revistasButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelAutor.setAlignmentX(Component.CENTER_ALIGNMENT);
        textFieldAutor.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelAno.setAlignmentX(Component.CENTER_ALIGNMENT);
        textFieldAno.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel2.add(labelTitulo);
        panel2.add(textFieldTitulo);
        panel2.add(labelAutor);
        panel2.add(textFieldAutor);
        panel2.add(labelAno);
        panel2.add(textFieldAno);
        
        panel.add(incluirButton);
        panel.add(revistasButton);
        panel.add(listagemButton);
         
        setLayout(new FlowLayout());
        // Add two panels inside one
        panel3.add(panel2);
        panel3.add(panel);
        // Add the panel to the frame
        add(panel3);
         
        // Set the window to be visible as the default to be false
        pack();
        setVisible(true);
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
      if(e.getSource() == revistasButton){
        // fecha a janela atual e abre a janela de revistas
        setVisible(false);
        dispose();
        SwingUtilities.invokeLater(new Runnable() {
          @Override
          public void run() {
              new RevistaPainel(tela);
          }
      });
      }else if(e.getSource() == incluirButton){
        String titulo = textFieldTitulo.getText();
        String autor = textFieldAutor.getText();
        int ano = Integer.parseInt(textFieldAno.getText());

        tela.addLivro(titulo,autor,ano);
      }else if(e.getSource() == listagemButton){
        JFrame frame = new JFrame();

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setRows(20);
        textArea.setColumns(50);
        
        List<Livro> livros = tela.getLivros();
        List<Revista> revistas = tela.getRevistas();
        StringBuilder parsedBiblioteca = new StringBuilder();
        
        livros.forEach(item ->{
          parsedBiblioteca.append(String.format("Livro: %s %s %d \n", item.getTitulo(),item.getAutor(), item.getAno()));
        });

        revistas.forEach(item ->{
          parsedBiblioteca.append(String.format("Revista: %s %s %d %d %d\n", item.getTitulo(),item.getOrg(), item.getVol(), item.getNro(),item.getAno()));
        });

        textArea.setText(parsedBiblioteca.toString());

        frame.add(textArea);

        frame.pack();
        frame.setVisible(true);
      }
  }
}