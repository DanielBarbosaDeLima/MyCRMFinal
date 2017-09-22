<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
       <meta charset="utf-8">
	   <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	   <title>My CRM</title>
	   <meta name="description" content="">
	   <meta name="viewport" content="width=device-width, initial-scale=1">
	
	   <link rel="stylesheet" href="css/bootstrap.min.css">
	   <style>
	        body {
	            padding-top: 50px;
	            padding-bottom: 20px;
	        }
	   </style>
	   <link rel="stylesheet" href="../css/style.css">
	   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.2/css/font-awesome.min.css">     
    </head>
	<body>
		<c:import url="../inc/header.jsp"/>
	
		<!-- Conteúdo principal da página -->
		<main class="container">
		<h1>Cadastro de Ordens de Serviço</h1>
			<a class="btn btn-primary" href="BuscarServicoServlet"><i class="fa fa-plus"></i> Nova Ordem</a>
		<hr/>
			 <form action="/MyCRM/ListarOdemDeServicoServlet" method="post">              
                <c:choose>
                    <c:when test="${not empty listaOrdens}">
                        <table  class="table table-striped">
                            <thead>
                                <tr>
                                    <td>#</td>
                                    <td>Serviço</td>
                                    <td>Cliente</td>
                                    <td>Data</td>
                                    <td>Hora</td>
                                </tr>
                            </thead>
                            <c:forEach var="ordem" items="${listaOrdens}">
                                <tr>
                                    <td>${ordem.id}</td>
                                    <td>${ordem.servico}</td>
                                    <td>${ordem.cliente}</td>
                                    <td>${ordem.data}</td>
                                    <td>${ordem.hora}</td>
                                </tr>
                            </c:forEach>               
                        </table>  
                    </c:when>                    
                    <c:otherwise>
                        <br>           
                        <div class="alert alert-info">
                            No people found matching your search criteria
                        </div>
                    </c:otherwise>
                </c:choose>                        
            </form>
		</main>
		<c:import url="../inc/footer.jsp"/>
	</body>
</html>

