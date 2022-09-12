/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import controller.ProjectController;
import controller.TaskController;
import java.sql.Date;
import java.util.List;
import model.Project;
import model.Task;

/**
 * @author Gustavo F. Vetter 30/08/2022
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
    /*  Teste de INSERT Project
        ProjectController projectcontroller = new ProjectController();
        Project project = new Project();
        project.setName("Teste x");
        project.setDescription("Description x");
        project.setCreatedAt(new Date(20220830));
        project.setUpdatedAt(new Date(20220830));
        System.out.println(project.toString());
        projectcontroller.insert(project);
        
        List<Project> project1 = projectcontroller.getAll();
        System.out.println("Total de projetos na lista: " + project1.size());
        
        //FUNCIONOU
     
        Teste de UPDATE Project
        ProjectController projectcontroller = new ProjectController();
        Project projecta = new Project();
        projecta.setId(4);
        projecta.setName("Novo teste 4 ");
        projecta.setDescription("Nova new4 description");
        projecta.setCreatedAt(new Date(20220830));
        projecta.setUpdatedAt(new Date(20220830));
        System.out.println(projecta.toString());
        projectcontroller.update(projecta);
        
        List<Project> project = projectcontroller.getAll();
        System.out.println("Total de projetos na lista: " + project.size());
        // FUNCIONOU
    
        Teste de removeById Project
        ProjectController projectcontroller = new ProjectController();
        projectcontroller.removeById(5);
        projectcontroller.removeById(6);
        projectcontroller.removeById(8);
        
        // Contagem das linhas de Projetos na tabela
        List<Project> project = projectcontroller.getAll();
        System.out.println("Total de projetos na lista: " + project.size());
        // FUNCIONOU
    */    
        
    
        //Teste de INSERT Task
        TaskController taskController = new TaskController();
        Task task = new Task();
        task.setIdProject(9);
        task.setName("Criar as telas da aplicacao");
        task.setDescription("Devem ser criadas telas para fazer os cadastros");
        task.setNotes("Sem comentarios");
        task.setIsCompleted(false);
        task.setDeadLine(new Date(20220831));
        task.setCreatedAt(new Date(20220831));
        task.setUpdatedAt(new Date(20220831));
        System.out.println(task.toString());
        taskController.insert(task);
    
        
//        //Teste de UPDATE task
//        task.setId(4);
//        task.setName("4 Alterar telas de criacao");
//        System.out.println(task.toString());
//        taskController.update(task);
//        List<Task> tasks = taskController.getAll(3);
//        System.out.println("Total de tarefas: " + tasks.size());
//        //System.out.println("Lista de tarefas: " + tasks.);
//        //FUNCIONOU
        
    
    }
    
}
