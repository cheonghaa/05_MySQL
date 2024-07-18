//package org.scoula;
//
//import org.scoula.lib.cli.App;
//import org.scoula.lib.cli.ui.Input;
//import org.scoula.lib.cli.ui.Menu;
//import org.scoula.lib.cli.ui.MenuItem;
//import org.scoula.todo.config.ProjectConfig;
//import org.scoula.todo.context.Context;
//import org.scoula.todo.exception.LoginFailException;
//import org.scoula.todo.service.AccountService;
//import org.scoula.todo.service.LoginService;
//import org.scoula.todo.service.TodoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.stereotype.Component;
//
//import java.sql.SQLException;
//
//@Component
//public class org.scoula.todo.TodoApp extends App {
//    Menu userMenu;
//    Menu anonymouseMenu;
//
////    LoginService loginService = new LoginService();
////    AccountService accountService = new AccountService();
////    TodoService todoService = new TodoService();
//
//    @Autowired
//    LoginService loginService;
//    @Autowired
//    AccountService accountService;
//    @Autowired
//    TodoService todoService;
//
////    LoginService loginService = Context.getBean(LoginService.class);
////    AccountService accountService = Context.getBean(AccountService.class);
////    TodoService todoService = Context.getBean(TodoService.class);
//
//    //GPT Ver
////    LoginService loginService;
////    AccountService accountService;
////    TodoService todoService;
//
//
//    @Override
//    public void init() {
////        Context.getContext().initializeBeans();
//
////        loginService = Context.getBean(LoginService.class);
////        accountService = Context.getBean(AccountService.class);
////        todoService = Context.getBean(TodoService.class);
//
//        anonymouseMenu = new Menu();
//        anonymouseMenu.add(new MenuItem("로그인", this::login));
//        anonymouseMenu.add(new MenuItem("가입 ", accountService::join));
//        anonymouseMenu.add(new MenuItem("종료 ", this::exit));
//
//        userMenu = new Menu();
//        //userMenu.add(new MenuItem("목록", todoService::print));
//        // pagination
//        userMenu.add(new MenuItem("목록", todoService::printPage));
//        userMenu.add(new MenuItem("검색", todoService::search));
//        userMenu.add(new MenuItem("상세", todoService::detail));
//        userMenu.add(new MenuItem("추가", todoService::create));
//        userMenu.add(new MenuItem("수정", todoService::update));
//        userMenu.add(new MenuItem("삭제", todoService::delete));
//        userMenu.add(new MenuItem("로그아웃 ", this::logout));
//        userMenu.add(new MenuItem("종료 ", this::exit));
//
//        setMenu(anonymouseMenu);
//
//    }
//
//    public void join() {
//    }
//
//    public void login() {
//        try {
//            loginService.login();
//            setMenu(userMenu);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (LoginFailException e) {
//            System.out.println(e.getMessage());
//        }
//
//    }
//
//    public void logout() {
//        if (Input.confirm("로그 아웃 하시겠습니까?")) {
//            Context.getContext().setUser(null);
//            setMenu(anonymouseMenu);
//        }
//    }
//
//    public void exit() {
//        System.out.println("프로그램을 종료합니다.");
//        System.exit(0);  // 프로그램 종료
//    }
//
//    //    public static void main(final String[] args) {
////        final org.scoula.todo.TodoApp app = new org.scoula.todo.TodoApp();
////        app.run();
////    }
//    public static void main(final String[] args) {
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(ProjectConfig.class);
//        org.scoula.todo.TodoApp app = ctx.getBean(org.scoula.todo.TodoApp.class);
//        app.run();
//    }
//
//
//}

//implementation project(':ScoulaCli')
//
//implementation 'org.springframework:spring-context:5.3.37'
//testImplementation 'org.springframework:spring-test:5.3.37'
//
//// https://mvnrepository.com/artifact/com.mysql/mysql-connector-j
//implementation 'com.mysql:mysql-connector-j:8.0.33'
//
//compileOnly 'org.projectlombok:lombok:1.18.30'
//annotationProcessor 'org.projectlombok:lombok:1.18.30'
//
//testCompileOnly 'org.projectlombok:lombok:1.18.30'
//testAnnotationProcessor 'org.projectlombok:lombok:1.18.30'
//
//testImplementation platform('org.junit:junit-bom:5.10.0')
//testImplementation 'org.junit.jupiter:junit-jupiter'
//testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.1'
//testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'
//
//implementation 'com.opencsv:opencsv:5.5'