<!DOCTYPE html>

<%@page import="service.PharmacieService"%>
<%@page import="entities.Zone"%>
<%@page import="service.ZoneService"%>
<%@page import="entities.Pharmacie"%>
<%@page import="service.PharmacienService"%>
<%@page import="entities.Ville"%>
<%@page import="service.VilleService"%>
<%@page import="entities.User"%>
<html lang="en" class="light-style layout-menu-fixed" dir="ltr"
	data-theme="theme-default" data-assets-path="assets/"
	data-template="vertical-menu-template-free">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

<title>Dashboard</title>

<meta name="description" content="" />

<!-- Favicon -->
<link rel="icon" type="image/x-icon"
	href="assets/img/favicon/favicon.ico" />

<!-- Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
	rel="stylesheet" />

<!-- Icons. Uncomment required icon fonts -->
<link rel="stylesheet" href="assets/vendor/fonts/boxicons.css" />

<!-- Core CSS -->
<link rel="stylesheet" href="assets/vendor/css/core.css"
	class="template-customizer-core-css" />
<link rel="stylesheet" href="assets/vendor/css/theme-default.css"
	class="template-customizer-theme-css" />
<link rel="stylesheet" href="assets/css/demo.css" />

<!-- Vendors CSS -->
<link rel="stylesheet"
	href="assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css" />

<!-- Page CSS -->

<!-- Helpers -->
<script src="assets/vendor/js/helpers.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/leaflet/1.7.1/leaflet.css" />

<!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
<!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
<script src="assets/js/config.js"></script>
</head>

<body>

	<%!User u;%>
	<%
	u = (User) session.getAttribute("user");
	if (u == null) {
		response.sendRedirect("Auth.jsp");
	}
	%>

	<!-- Layout wrapper -->
	<div class="layout-wrapper layout-content-navbar">
		<div class="layout-container">
			<!-- Menu -->

			<jsp:include page="/WEB-INF/template/sidemenu.jsp" />
			<!-- / Menu -->

			<!-- Layout container -->
			<div class="layout-page">
				<!-- Navbar -->

				<!-- / Navbar -->

				<!-- Content wrapper -->
				<div class="content-wrapper">
					<!-- Content -->

					<div class="container-xxl flex-grow-1 container-p-y">
						<h4 class="fw-bold py-3 mb-4">
							<span class="text-muted fw-light"></span> Gestion Des Pharmacies
						</h4>

						<!-- Basic Layout & Basic with Icons -->
						<div class="row">
							<!-- Basic Layout -->
							<div class="col-xxl">
								<div class="card mb-4">
									<div
										class="card-header d-flex align-items-center justify-content-between">
										<h5 class="mb-0">Ajouter Des Pharmacies</h5>

									</div>
									<div class="card-body">
										<form id="formv" name="formville" >
											<div class="row mb-3">
												<label class="col-sm-2 col-form-label"
													for="basic-default-name">Nom</label>
												<div class="col-sm-10">
													<input type="text" name="nom" id="nom" class="form-control"
														id="basic-default-name" placeholder="Enter Nom de Ville" />
													<input type="hidden" id="id" class="form-control"
														id="input-name" placeholder="id"> <input
														type="hidden" id="op" class="form-control" id="input-name"
														placeholder="id">
												</div>
											</div>
											<div class="row mb-3">
												<label class="col-sm-2 col-form-label"
													for="basic-default-name">Address</label>
												<div class="col-sm-10">
													<input type="text" name="address" id="address" class="form-control"
														id="basic-default-name" placeholder="Enter Nom de Ville"  />
												</div>
												
											</div>
											<div class="row mb-3">
												<label class="col-sm-2 col-form-label"
													for="basic-default-name">longitude</label>
												<div class="col-sm-10">
													<input type="text" name="latitude" id="lat" class="form-control"
														id="basic-default-name" placeholder="Enter Nom de Ville" readonly />
												</div>
												
											</div>
											<div class="row mb-3">
												<label class="col-sm-2 col-form-label"
													for="basic-default-name">latitude</label>
												<div class="col-sm-10">
													<input type="text" name="longitude" id="lng" class="form-control"
														id="basic-default-name" placeholder="Enter Nom de Ville" readonly />
												</div>
												
											</div>
											<div class="row mb-3">
												<label class="col-sm-2 col-form-label"
													for="basic-default-name">Pharmacien</label>
												<div class="col-sm-10">
													<select class="form-select" name="pharmacien" id="pharmacien"
														aria-label="Default select example">
														<%
														PharmacienService s = new PharmacienService();
														for (User v : s.findAll()) {
														%>

														<option value="<%=v.getId()%>"><%=v.getPrenom()%> <%=v.getNom()%></option>

														<%
														}
														%>
													</select>

												</div>
											</div>
											<div class="row mb-3">
												<label class="col-sm-2 col-form-label"
													for="basic-default-name">Ville</label>
												<div class="col-sm-10">
													<select class="form-select"  id="ville"
														aria-label="Default select example">
														<%
														VilleService vd = new VilleService();
														for (Ville vi : vd.findAll()) {
														%>

														<option value="<%=vi.getId()%>"><%=vi.getNome()%></option>

														<%
														}
														%>
													</select>

												</div>
											</div>
											<div class="row mb-3">
												<label class="col-sm-2 col-form-label"
													for="basic-default-name">Zone</label>
												<div class="col-sm-10">
													<select class="form-select" name="zone" id="zone"
														aria-label="Default select example">
														
													</select>

												</div>
											</div>
											
											<div class="row justify-content-end">
												<div class="col-sm-10">
													<button type="submit" class="add btn btn-primary">Ajouter</button>
												</div>
											</div>
										</form>

									</div>

								</div>
								
								<div id="map" style="height:80%;"></div>
								</br>
								
								<div class="card">
									<h5 class="card-header">List Des Pharmacies</h5>
									<div class="table-responsive text-nowrap">
										<table class="table">
											<thead>
												<tr class="text-nowrap">
													<th>#</th>
													<th>Nom</th>
													<th>Adress</th>
													<th>Longitude</th>
													<th>Latitude</th>
													<th>Pharmacien<th>
													<th>Zone<th>
												</tr>
											</thead>
											<tbody>
												<%
												PharmacieService ps = new PharmacieService();
												for (Pharmacie v : ps.findAll()) {
												%>
												<tr>
													<td scope="row"><%=v.getId()%></td>
													<td><%=v.getNom()%></td>
													<td><%=v.getLongitude()%></td>
													<td><%=v.getLatitude()%></td>
													<td><%=v.getPharmacien().getNom()%></td>
													<td><%=v.getZone().getNom()%></td>
													<td>
														<div class="dropdown">
															<button type="button"
																class="btn p-0 dropdown-toggle hide-arrow"
																data-bs-toggle="dropdown">
																<i class="bx bx-dots-vertical-rounded"></i>
															</button>
															<div class="dropdown-menu">
																<a class="dropdown-item"
																	onclick="recoverInfo(<%=v.getId()%>,'<%=v.getNom()%>');"><i
																	class="bx bx-edit-alt me-1"></i> Edit</a> <a
																	class="dropdown-item"
																	href="VilleController?id=<%=v.getId()%>&op=delete"><i
																	class="bx bx-trash me-1"></i> Delete</a>
															</div>
														</div>
													</td>
												</tr>
												<%
												}
												%>
											</tbody>
										</table>
										
									</div>
									
								</div>
								</br>
								</br>
							</div>
							<!-- Basic with Icons -->

						</div>

					</div>
					<!-- / Content -->



					<div class="content-backdrop fade"></div>
				</div>
				<!-- Content wrapper -->
			</div>
			<!-- / Layout page -->
		</div>

		<!-- Overlay -->
		<div class="layout-overlay layout-menu-toggle"></div>
	</div>
	<!-- / Layout wrapper -->



	<!-- Core JS -->
	<!-- build:js assets/vendor/js/core.js -->

	<script src="assets/vendor/libs/popper/popper.js"></script>
	<script src="assets/vendor/js/bootstrap.js"></script>
	<script src="assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

	<script src="assets/vendor/js/menu.js"></script>
	<!-- endbuild -->

	<!-- Vendors JS -->

	<!-- Main JS -->
	<script src="assets/js/main.js"></script>

	<!-- Page JS -->

	<!-- Place this tag in your head or just before your close body tag. -->
	<script src="js/script4.js" type="text/javascript"></script>
	  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB-QRyYn89DQ3c1iu-PTXqXCpm6PadJxl8&callback=initMap&v=weekly&channel=2" async></script>
	  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	  <script >
	$(document).ready(function () {
		//$("#ville option[value='']").attr('selected', true)
		console.log("yes");
	    $("#ville").change(function (e) {
	    	var ville=$('#ville').val();
	    	console.log(ville);
	    		e.preventDefault();
	            $.ajax ({
	            url: 'ZoneByVilleController',
	            data: {ville:ville},
	            datatype: 'json',
	            type: 'POST',
	            success: function (data) {
	            	$("#zone").html(data);
	            	
	            	console.log('success');
	            	//console.log(data);
	            	
	               
	            },error: function(request,status,errorThrown)
	            {
	            	console.log(request);
	            	console.log(status)
	            	console.log(errorThrown)
	            }
	           
	        })
	    })


	})
	
	</script>
	
</body>
</html>
