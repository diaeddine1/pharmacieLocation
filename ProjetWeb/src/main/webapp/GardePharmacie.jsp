<!DOCTYPE html>

<%@page import="entities.PharmacieDeGarde"%>
<%@page import="entities.Garde"%>
<%@page import="service.GradeService"%>
<%@page import="service.PharmacieDeGardeService"%>
<%@page import="entities.Pharmacie"%>
<%@page import="service.PharmacieService"%>
<%@page import="entities.Zone"%>
<%@page import="service.ZoneService"%>
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
							<span class="text-muted fw-light"></span> Gestion Des Pharmacie De Garde
						</h4>

						<!-- Basic Layout & Basic with Icons -->
						<div class="row">
							<!-- Basic Layout -->
							<div class="col-xxl">
								<div class="card mb-4">
									<div
										class="card-header d-flex align-items-center justify-content-between">
										<h5 class="mb-0">Ajouter Des Pharmacie De Garde</h5>

									</div>
									<div class="card-body">
										<form name="formville" action="PharmacieDeGardeController" method="post">
											<div class="row mb-3">
												<label class="col-sm-2 col-form-label"
													for="basic-default-name">Pharmacie</label>
												<div class="col-sm-10">
													<select class="form-select"  id="pharmacie"
														aria-label="Default select example">
														<%
														PharmacieService ps = new PharmacieService();
														for (Pharmacie p : ps.findAll()) {
														%>
														<option value="" selected disabled>CHOISIR VOTRE PHARMACIE</option>
														<option value="<%=p.getId()%>"><%=p.getNom()%></option>

														<%
														}
														%>
													</select>
												</div>
											</div>
											<div class="row mb-3">
												<label class="col-sm-2 col-form-label"
													for="basic-default-name">Garde</label>
												<div class="col-sm-10">
													<select class="form-select" id="garde"
														aria-label="Default select example">
														<%
														GradeService gs = new GradeService();
														for (Garde g : gs.findAll()) {
														%>
														<option value="" selected disabled>CHOISIR LE TYPE DE GARDE</option>
														
														<option value="<%=g.getId()%>"><%=g.getType()%></option>

														<%
														}
														%>
													</select>

												</div>
											</div>
											<div class="mb-3 row">
                        <label for="html5-date-input" class="col-md-2 col-form-label">Date D'ebut</label>
                        <div class="col-md-10">
                          <input class="form-control" id="datedebut" type="date" value="2021-06-18" id="html5-date-input">
                        </div>
                      </div>
											<div class="mb-3 row">
                        <label for="html5-date-input" class="col-md-2 col-form-label">Date Fin</label>
                        <div class="col-md-10">
                          <input class="form-control" id="datefin" type="date" value="2021-06-18" id="html5-date-input">
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
								<div class="card">
									<h5 class="card-header">List Des Pharmacie de Garde</h5>
									<div class="table-responsive text-nowrap">
										<table class="table">
											<thead>
												<tr class="text-nowrap">
													<th>#</th>
													<th>Nom De Pharmacie</th>
													<th>Type De Garde</th>
													
													<th>Date Fin</th>
													<th>Actions</th>
												</tr>
											</thead>
											<tbody>
												<%
												
												PharmacieDeGardeService zs = new PharmacieDeGardeService();
												for (PharmacieDeGarde v : zs.findAll()) {
												%>
												<tr>
												
													
													<td scope="row"><%=v.getPk().getGarde()%></td>
													<td><%=v.getPharmacie().getNom()%></td>
													<td><%=v.getGarde().getType()%></td>
													
													
													<td><%=v.getDateFin()%></td>
													
													<td>
														<div class="dropdown">
															<button type="button"
																class="btn p-0 dropdown-toggle hide-arrow"
																data-bs-toggle="dropdown">
																<i class="bx bx-dots-vertical-rounded"></i>
															</button>
															<div class="dropdown-menu">
																<a class="dropdown-item"
																	onclick="recoverInfo(<%=v.getPk()%>,'<%= v.getClass() %>','<%=v.getDateFin()%>');"><i
																	class="bx bx-edit-alt me-1"></i> Edit</a> <a
																	class="dropdown-item"
																	href="ZoneController?id=<%=v.getPk()%>&op=delete"><i
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
	<script src="assets/vendor/libs/jquery/jquery.js"></script>
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
	
</body>
</html>