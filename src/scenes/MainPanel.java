package scenes;

import task.Task;
import task.TaskList;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class MainPanel extends JPanel implements ListSelectionListener, MouseListener, ItemListener {

    private JLabel lbTitle;
    private JLabel lbDescription;
    private JLabel lbTasks;
    private JLabel lbPriority;
    private JLabel lbStatus;
    private JLabel lbOrderBy;
    private JTextField tfTitle;
    private JTextArea taDescription;
    private JButton btnSubmit;
    private JButton btnClear;
    private JButton btnSort;
    private DefaultListModel<Task> dlsTasks;
    private JList<Task> lsTasks;
    private JButton btnDelete;
    private JScrollPane spTasks;
    private JComboBox<String> cbPriority;
    private JComboBox<String> cbStatus;
    private JComboBox<String> cbOrderBy;

    private TaskList taskManager;

    {
        //Labels
        lbTasks = new JLabel("Tarefas");
        lbTitle = new JLabel("Título");
        lbDescription = new JLabel("Descrição");
        lbPriority = new JLabel("Prioridade");
        lbStatus = new JLabel("Status");
        lbOrderBy = new JLabel("Ordernar por");
        //Buttons
        btnSubmit = new JButton("Salvar");
        btnClear = new JButton("Limpar");
        btnDelete = new JButton("Deletar");
        btnSort = new JButton("Ordenar");
        //TextComponents
        tfTitle = new JTextField();
        taDescription = new JTextArea();
        //Lists
        dlsTasks = new DefaultListModel<>();
        lsTasks = new JList<>(dlsTasks);
        //ScrollPanes
        spTasks = new JScrollPane(lsTasks);
        //ComboBoxes
        cbPriority = new JComboBox<>(new String[]{"Baixa", "Média", "Alta"});
        cbStatus = new JComboBox<>(new String[]{"Para fazer", "Em andamento", "Concluída"});
        cbOrderBy = new JComboBox<>(new String[]{"Título", "Prioridade", "Andamento"});
    }

    public MainPanel(TaskList taskManager){
        this.taskManager = taskManager;
        btnSubmit.addMouseListener(this);
        btnClear.addMouseListener(this);
        btnDelete.addMouseListener(this);
        btnSort.addMouseListener(this);
        lsTasks.addListSelectionListener(this);
        cbOrderBy.addItemListener(this);
        setOpaque(true);
        setVisible(true);
        configure();

//        taskManager.add(Task.getTask("Arrumar a cama", "", "Baixa", "Para fazer"));
//        taskManager.add(Task.getTask("Estudar programação", "", "Alta", "Em andamento"));
//        taskManager.add(Task.getTask("Tocar violão", "", "Baixa", "Concluído"));
//        taskManager.add(Task.getTask("Lavar as roupas", "", "Média", "Para fazer"));
//        taskManager.add(Task.getTask("Lavar a louça", "", "Média", "Para fazer"));
//        taskManager.add(Task.getTask("Projeto de conclusão", "", "Alta", "Em andamento"));
//        taskManager.add(Task.getTask("Passear com o cachorro", "", "Médio", "Concluído"));
//        taskManager.add(Task.getTask("Pagar as contas", "", "Alto", "Para fazer"));
//        taskManager.add(Task.getTask("Ir ao mercado", "", "Baixa", "Para fazer"));
//        taskManager.add(Task.getTask("Entregar tarefas", "", " Média", "Em andamento"));
//        dlsTasks.addAll(taskManager.sortBy("Título"));
    }

    private void configure(){
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(lbTasks)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(lbOrderBy)
                                .addComponent(cbOrderBy)
                        )
                        .addComponent(spTasks)
                        .addComponent(btnDelete)
                )
                .addGroup(layout.createParallelGroup()
                        .addComponent(lbTitle)
                        .addComponent(tfTitle)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(lbPriority)
                                .addComponent(cbPriority, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbStatus)
                                .addComponent(cbStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                        )
                        .addComponent(lbDescription)
                        .addComponent(taDescription)
                        .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSubmit)
                                .addComponent(btnClear)
                        )
                )
        );

        layout.setVerticalGroup(layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTasks)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(lbOrderBy)
                                .addComponent(cbOrderBy)
                        )
                        .addComponent(spTasks)
                        .addComponent(btnDelete)
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTitle)
                        .addComponent(tfTitle, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                .addComponent(lbPriority)
                                .addComponent(cbPriority, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbStatus)
                                .addComponent(cbStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                        )
                        .addComponent(lbDescription)
                        .addComponent(taDescription)
                        .addGroup(layout.createParallelGroup()
                                .addComponent(btnSubmit)
                                .addComponent(btnClear)
                        )
                )
        );

        cbPriority.setSelectedItem("Média");

        lsTasks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lsTasks.addListSelectionListener(this);
        lsTasks.setFocusable(false);

        spTasks.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spTasks.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        spTasks.setPreferredSize(new Dimension(150, 200));

        taDescription.setPreferredSize(new Dimension(350, 0));
        taDescription.setBorder(tfTitle.getBorder());
        taDescription.setLineWrap(true);

        layout.linkSize(SwingConstants.HORIZONTAL, tfTitle, taDescription);
        layout.linkSize(SwingConstants.HORIZONTAL, btnSubmit, btnClear, btnDelete);

        Arrays.stream(this.getComponents()).forEach(component -> {
            component.setFont(new Font("Tahoma", Font.PLAIN, 12));
            if(component instanceof JLabel || component instanceof JButton )
                component.setFont(component.getFont().deriveFont(Font.BOLD));
            if(component instanceof JButton || component instanceof JComboBox<?>){
                component.setFocusable(false);
            }
        });
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int index = lsTasks.getSelectedIndex(); //get selected index
        if (index >= 0)
            setFields(dlsTasks.get(index));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent() == btnSubmit)
            submitTask();
        else if(e.getComponent() == btnDelete)
            deleteTask();
        else if(e.getComponent() == btnClear)
            resetFields();
        else if(e.getComponent() == btnSort)
            sortBy((String) cbOrderBy.getSelectedItem());
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        sortBy((String) cbOrderBy.getSelectedItem());
    }

    private void submitTask(){
        Task submitingTask = createTask();
        if(submitingTask == null){
            JOptionPane.showMessageDialog(this,
                    "Você precisa dar um título para sua tarefa!");
        }else{
            Task alreadyExistingTask = addTask(submitingTask);
            if(alreadyExistingTask == null){
                JOptionPane.showMessageDialog(this,
                        "Tarefa \"%s\" criada com sucesso!".formatted(submitingTask.getTitle()));
                resetFields();
            }else{
                var selection = JOptionPane.showOptionDialog(this,
                        "Tarefa \"%s\" já cadastrada!".formatted(alreadyExistingTask.getTitle()),
                        "",
                        0,
                        1,
                        null,
                        new String[]{"Atualizar", "Cancelar"},
                        null);
                if(selection == 0)
                    updateTask(alreadyExistingTask);
            }
        }
    }

    private void deleteTask(){
        int index = lsTasks.getSelectedIndex(); //get selected index
        if (index < 0){
            JOptionPane.showMessageDialog(this,
                    "Selecione uma tarefa para excluir!");
        }else{
            Task task = dlsTasks.getElementAt(index);
            if(taskManager.delete(task)){
                dlsTasks.remove(index);
                JOptionPane.showMessageDialog(this,
                        "Tarefa \"%s\" removida com sucesso!".formatted(task.getTitle()));
                resetFields();
            }
        }
    }

    private void resetFields(){
        tfTitle.setText("");
        taDescription.setText("");
        cbStatus.setSelectedItem("Para fazer");
        cbPriority.setSelectedItem("Média");
        lsTasks.setSelectedIndex(-1);
    }

    private void setFields(Task task){
        tfTitle.setText(task.getTitle());
        taDescription.setText(task.getDescription());
        cbStatus.setSelectedItem(task.getStatus().toString());
        cbPriority.setSelectedItem(task.getPriority().toString());
    }

    private void updateTask(Task task){
        task.setDescription(taDescription.getText());
        task.setPriority((String) cbPriority.getSelectedItem());
        task.setStatus((String) cbStatus.getSelectedItem());
    }

    private Task createTask(){
        return Task.getTask(tfTitle.getText(),
                taDescription.getText(),
                (String)cbPriority.getSelectedItem(),
                (String)cbStatus.getSelectedItem());
    }

    private Task addTask(Task task){
        if(!taskManager.add(task))
            return taskManager.find(task.getTitle());
        dlsTasks.addElement(task);
        return null;
    }

    private Task getTask(String title){
        return taskManager.find(title);
    }

    private void sortBy(String attribute){
        dlsTasks.removeAllElements();
        dlsTasks.addAll(taskManager.sortBy(attribute));
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
