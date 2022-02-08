<%@page import="Model.ContaDAO"%>
/*Não sei o que substituiria o model conta*/
<%@page import="aplicacao.Conta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.CarrinhoDAO"%>
<%@page import="aplicacao.Carrinho"%>
<%@page import="aplicacao.Compra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="Head.html" %>
        <title>Nova Compra/title>
    </head>
    <body>        
        <div id="wrapper">
            <%@include file="navbarUsuario.html" %>
            
            <div class="rd-flex flex-column" id="content-wrapper">
                <div id="content">
                    <%@include file="navbar.jsp" %>
                    <div class="container-fluid">
                        <div class="row justify-content-center">
                            <div class="col-lg-11 col-xl-11">
                                <div class="row justify-content-center align-items-center">
                                    <div class="col-6 form p-5 my-auto shadow">
                                        <div class="d-grid  d-md-flex justify-content-md-end">
                                            <a type="button" class="btn-close" aria-label="Close" href="dashboardUsuario.jsp"></a>
                                        </div>
                                        <%
                                            Compra aux = (Compra)request.getAttribute("compra");
                                         %>
                                        <h4 class="text-center">Compra</h4>
                                        <form method="POST" action="CompraController">
                                            <input type="hidden" class="form-control" name="id">
                                             <div class="form-group mb-3">
                                                <label for="numerodocartao">Numero do cartao</label>
                                                <input type="text" class="form-control" name="data" value="<%=aux.getnumerodocartao()%>">
                                            </div>
                                           <div class="form-group mb-3">
                                                <label for="cpf">CPF</label>
                                                <input type="text" class="form-control" name="data" value="<%=aux.getcpf()%>">
                                            </div>
                                            <div class="form-group mb-3">
                                                <label for="data">Data</label>
                                                <input type="text" class="form-control" name="data" value="<%=aux.getData()%>">
                                            </div>
                                            <div class="form-group mb-3">
                                                <label for="senha">Descrição</label>
                                                <input type="text" class="form-control" name="descricao" max="100" value="<%=aux.getDescricao()%>">
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

