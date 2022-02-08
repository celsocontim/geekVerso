<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="aplicacao.Usuarios"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="Head.html" %>
        <title>Usuario</title>
    </head>
    <body>        
        <div id="wrapper">
            <%@include file="navbarAdmin.html" %>
            
            <div class="rd-flex flex-column" id="content-wrapper">
                <div id="content">
                    <%@include file="navbar.jsp" %>
                    <div class="container-fluid">
                        <div class="row justify-content-center">
                            <div class="col-lg-11 col-xl-11">
                                <div class="row justify-content-center align-items-center">
                                    <div class="col-6 form p-5 my-auto shadow">
                                        <div class="d-grid  d-md-flex justify-content-md-end">
                                            <a type="button" class="btn-close" aria-label="Close" href="dashboardAdmin.jsp"></a>
                                        </div>
                                        <%
                                            Usuarios aux = (Usuarios)request.getAttribute("usuarios");
                                         %>
                                        <h4 class="text-center"><% if(aux.getNome().isEmpty()){
                                            out.println("Cadastrar");
                                        }else {
                                            out.println("Editar");
                                        }
                                        %> 
                                        Usuário</h4>
                                        <form method="POST" action="UsuariosController">
                                            <input type="hidden" class="form-control" name="id" value="<%= aux.getId() %>">
                                            <div class="form-group mb-3">
                                                <label for="nome">Nome</label>
                                                <input type="text" class="form-control" name="nome" value="<%= aux.getNome() %>" max="20">
                                            </div>
                                            <div class="form-group mb-3">
                                                <label for="cpf">CPF</label>
                                                <input type="text" class="form-control" name="cpf" value="<%= aux.getCpf() %>" max="14" pattern="\d{3}\.\d{3}\.\d{3}-\d{2}">
                                            </div> 

                                            <div class="form-group mb-3">
                                                <label for="email">Email</label>
                                                <input type="text" class="form-control" name="email" value="<%= aux.getEmail() %>" max="20">
                                            </div>

                                            <div class="form-group mb-3">
                                                <label for="telefone">Telefone</label>
                                                <input type="text" class="form-control" name="telefone" value="<%= aux.getTelefone() %>" max="11">
                                            </div> 

                                            <div class="form-group mb-3">

                                                <label for="senha">Senha</label>
                                                <input type="text" class="form-control" name="senha" value="<%= aux.getSenha() %>" max="255">
                                            </div>
                                     
                                            <div class="form-group">
                                                <button type="submit" class="btn align-self-right salvar">Salvar</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div> 

                        </div>
                        
                          

                    </div>
                </div>
                
                
            </div>
        </div>
        <%@include file="scriptsGerais.html" %>
    </body>
</html>
