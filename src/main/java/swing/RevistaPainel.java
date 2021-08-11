package swing;

import javax.swing.*;

import tela.Tela;
import entities.Livro;
import entities.Revista;

import java.awt.event.*;
import java.util.List;
import java.awt.*;



public class RevistaPainel extends JFrame implements ActionListener {

    private JButton incluirButton;
    private JButton listagemButton;
    private JButton livrosButton;
    private JLabel labelTitulo;
    private JTextField textFieldTitulo;
    private JLabel labelOrg;
    private JTextField textFieldOrg;
    private JLabel labelVol;
    private JTextField textFieldVol;
    private JLabel labelNro;
    private JTextField textFieldNro;
    private JLabel labelAno;
    private JTextField textFieldAno;
    private Tela tela;

  public RevistaPainel(Tela tela) {
        super("Material Bibliográfico");

        this.tela = tela;

        setDefaultLookAndFeelDecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
         
        incluirButton = new JButton("Incluir");        
        listagemButton = new JButton("Listagem");
        livrosButton = new JButton("Livros");

        // Adicionando actionListener nos botoes
        incluirButton.addActionListener(this);
        listagemButton.addActionListener(this);
        livrosButton.addActionListener(this);

        labelTitulo = new JLabel("Titulo: ");
        textFieldTitulo = new JTextField(15);
        labelOrg = new JLabel("Org: ");
        textFieldOrg = new JTextField(15);
        labelVol = new JLabel("Vol: ");
        textFieldVol = new JTextField(4);
        labelNro = new JLabel("Nro: ");
        textFieldNro = new JTextField(4);
        labelAno = new JLabel("Ano : ");
        textFieldAno = new JTextField(4);
         
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
         
        panel2.setBorder(BorderFactory.createTitledBorder("Revistas"));
         
        BoxLayout layout4 = new BoxLayout(panel4, BoxLayout.X_AXIS);
        BoxLayout layout3 = new BoxLayout(panel3, BoxLayout.Y_AXIS);
        BoxLayout layout2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
        BoxLayout layout = new BoxLayout(panel, BoxLayout.X_AXIS);
        
        panel.setLayout(layout);
        panel2.setLayout(layout2);
        panel3.setLayout(layout3);
        panel4.setLayout(layout4);
         
        incluirButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        listagemButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        textFieldTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        livrosButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelOrg.setAlignmentX(Component.CENTER_ALIGNMENT);
        textFieldOrg.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelVol.setAlignmentX(Component.CENTER_ALIGNMENT);
        textFieldVol.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelNro.setAlignmentX(Component.CENTER_ALIGNMENT);
        textFieldNro.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelAno.setAlignmentX(Component.CENTER_ALIGNMENT);
        textFieldAno.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        panel2.add(labelTitulo);
        panel2.add(textFieldTitulo);
        panel2.add(labelOrg);
        panel2.add(textFieldOrg);
        panel2.add(panel4);
        panel4.add(labelVol);
        panel4.add(textFieldVol);
        panel4.add(labelNro);
        panel4.add(textFieldNro);
        panel4.add(labelAno);
        panel4.add(textFieldAno);

        
        panel.add(incluirButton);
        panel.add(livrosButton);
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
    if(e.getSource() == livrosButton){
      // fecha a janela atual e abre a janela de revistas
      setVisible(false);
      dispose();
      SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            new LivroPainel(tela);
        }
    });
    }else if(e.getSource() == incluirButton){
      String titulo = textFieldTitulo.getText();
      String org = textFieldOrg.getText();
      int vol = Integer.parseInt(textFieldVol.getText());
      int nro = Integer.parseInt(textFieldNro.getText());
      int ano = Integer.parseInt(textFieldAno.getText());

      tela.addRevista(titulo, org, vol, nro, ano);
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
