<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@page import="Entity.Medicine"%>
<%@page import="DataAccess.MedicineDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
List<Medicine> medicineList = (List<Medicine>) request.getAttribute("medicineList");
if (medicineList == null && request.getParameter("service") == null) {
    MedicineDAO dao = new MedicineDAO();
    try {
        medicineList = dao.getAllMedicines();  
    } catch (Exception e) {
        medicineList = new ArrayList<>();
        e.printStackTrace();
    }
    request.setAttribute("medicineList", medicineList);
}
%>
<html lang="en-US" dir="ltr">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- ===============================================-->
        <!--    Document Title-->
        <!-- ===============================================-->
        <title>Foodwagon | Responsive, Ecommerce &amp; Business Templatee</title>


        <!-- ===============================================-->
        <!--    Favicons-->
        <!-- ===============================================-->

        <link rel="manifest" href="assets/img/favicons/manifest.json">
        <meta name="msapplication-TileImage" content="assets/img/favicons/mstile-150x150.png">
        <meta name="theme-color" content="#ffffff">


        <!-- Icon Font Stylesheet -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">
        <!-- ===============================================-->
        <!--    Stylesheets-->
        <!-- ===============================================-->
        <link href="assets/css/theme.css" rel="stylesheet" />


        <link href="Presentation/assets/css/theme.css" rel="stylesheet">
        <script src="Presentation/vendors/is/is.min.js"></script>

    </head>


    <body>

        <!-- ===============================================-->
        <!--    Main Content-->
        <!-- ===============================================-->
        <main class="main" id="top">
            <nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top" data-navbar-on-scroll="data-navbar-on-scroll">
                <div class="container"><a class="navbar-brand d-inline-flex" href="index.html"><img class="d-inline-block"  alt="logo" /><span class="text-1000 fs-3 fw-bold ms-2 text-gradient">foodwaGon</span></a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"> </span></button>
                    <div class="collapse navbar-collapse border-top border-lg-0 my-2 mt-lg-0" id="navbarSupportedContent">
                        <div class="mx-auto pt-5 pt-lg-0 d-block d-lg-none d-xl-block">
                            <p class="mb-0 fw-bold text-lg-center">Deliver to: <i class="fas fa-map-marker-alt text-warning mx-2"></i><span class="fw-normal">Current Location </span><span>Mirpur 1 Bus Stand, Dhaka</span></p>
                        </div>
                        <form class="d-flex mt-4 mt-lg-0 ms-lg-auto ms-xl-0">
                            <div class="input-group-icon pe-2"><i class="fas fa-search input-box-icon text-primary"></i>
                                <input class="form-control border-0 input-box bg-100" type="search" placeholder="Search Food" aria-label="Search" />
                            </div>
                            <button class="btn btn-white shadow-warning text-warning" type="submit"> <i class="fas fa-user me-2"></i>Login</button>
                        </form>
                    </div>
                </div>
            </nav>
            <section class="py-5 bg-primary" id="home">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-11 text-center text-md-start py-6">
                            <h2 class="display-5 text-light ">Manager Medicine</h2>
                            <div class="card">
                                <div class="card-body" style="padding-left:50px">
                                    <ul class="nav nav-tabs mb-3" role="tablist">
                                        <li class="nav-item">
                                            <a href="#addMedicine" class="nav-link" data-bs-toggle="modal">Add Medicine</a>
                                        </li>
                                        <li class="nav-item">
                                            <form action="${pageContext.request.contextPath}/MedicineManagement" method="POST">
                                                <input type="hidden" name="service" value="expiredSoon">
                                                <button class="nav-link " type="submit">Expired Soon</button>
                                            </form>
                                        </li>
                                        <li class="nav-item">
                                            <form action="${pageContext.request.contextPath}/MedicineManagement" method="POST">
                                                <input type="hidden" name="service" value="overDate">
                                                <button class="nav-link  " type="submit">Over Date</button>
                                            </form>
                                        </li>
                                        <li class="nav-item">
                                            <form action="${pageContext.request.contextPath}/MedicineManagement" method="POST">
                                                <input type="hidden" name="service" value="sortByName">
                                                <button class="nav-link " type="submit">Sort By Name</button>
                                            </form>
                                        </li>
                                        <li class="nav-item">
                                            <form action="${pageContext.request.contextPath}/MedicineManagement" method="POST">
                                                <input type="hidden" name="service" value="sortByPrice">
                                                <button class="nav-link " type="submit">Sort By Price</button>
                                            </form>
                                        </li>
                                        <li class="nav-item">
                                            <form action="${pageContext.request.contextPath}/MedicineManagement" method="POST">
                                                <input type="hidden" name="service" value="sortByQuantity">
                                                <button class="nav-link " type="submit">Sort By Quantity</button>
                                            </form>
                                        </li>
                                        <li class="nav-item">
                                            <form action="${pageContext.request.contextPath}/MedicineManagement" method="POST">
                                                <input type="hidden" name="service" value="getAllMedicines">
                                                <button class="nav-link " type="submit">All Medicines</button>
                                            </form>
                                        </li>


                                    </ul>
                                    <div class="tab-content">
                                        <div class="tab-pane fade show active">
                                            <form class="d-flex gap-2" method="POST" action="${pageContext.request.contextPath}/MedicineManagement">
                                                <i class="input-box-icon text-primary"></i>
                                                <div class="input-group-icon pe-2" style="width: 350px">
                                                    <i class="fas fa-search input-box-icon text-primary"></i>
                                                    <input class="form-control border-0 input-box bg-100"
                                                           type="search"
                                                           name="keyword"
                                                           placeholder="Enter Medicine Name"
                                                           aria-label="Search" />
                                                </div>
                                                <input type="hidden" name="service" value="search">
                                                <button class="btn btn-danger" type="submit">Search</button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>


            <div id="addMedicine" class="modal fade">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="${pageContext.request.contextPath}/MedicineManagement" method="post">
                            <div class="modal-header">						
                                <h4 class="modal-title">Add Medicine</h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                            </div>
                            <div class="modal-body">	
                                <div class="form-group">
                                    <label>Image URL</label>
                                    <input type="text" name="image" class="form-control" pattern=".*\.(jpg|jpeg|png|gif)$" 
                                           title="Link ?nh ph?i k?t thúc b?ng .jpg, .jpeg, .png ho?c .gif" 
                                           required>
                                </div>
                                <div class="form-group">
                                    <label>Medicine Name</label>
                                    <input type="text" name="medicineName" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label>Quantity</label>
                                    <input type="number" name="quantity" class="form-control"  min="0" step="1" required>
                                </div>
                                <div class="form-group">
                                    <label>Price</label>
                                    <input type="number" name="price" class="form-control"  min="0" step="0.01"required>
                                </div>
                                <div class="form-group">
                                    <label>EXP Date</label>
                                    <input type="date" name="expiryDate" class="form-control" required>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <input type="submit" name="submit" class="btn btn-success" value="Add Medicine">
                                <input type="hidden" name="service" value="addMedicine">
                            </div>
                        </form>
                    </div>
                </div>
            </div>





            <!-- ============================================-->
            <!-- <section> begin ============================-->



            <section id="testimonial">
                <div class="container">
                    <div class="row h-25">
                        <div class="col-lg-7 mx-auto text-center mb-6">
                            <h5 class="fw-bold fs-3 fs-lg-5 lh-sm mb-3">All Medicine In Hospital</h5>
                        </div>
                    </div>
                    <div class="row">
                        <c:forEach var="medicine" items="${medicineList}">
                            <div class="col-sm-6 col-md-4 col-lg-3 h-100 mb-5">
                                <div class="card card-span text-white rounded-3" style="height: 350px;">
                                    <img class="img-fluid rounded-3" src="${medicine.image}" style="height: 250px; object-fit: cover; width: 100%;" />
                                    <div class="card-img-overlay ps-0">
                                        <span class="badge bg-danger ms-2 me-1 p-2">
                                            <i class="fas fa-tag me-2 fs-0"></i>
                                            <span class="fs-0">${medicine.price} VND</span>
                                        </span>
                                        <span class="badge bg-primary ms-2 me-1 p-2">
                                            <i class="fas fa-clock me-1 fs-0"></i>
                                            <span class="fs-0">
                                                <fmt:formatDate value="${medicine.expiryDate}" pattern="dd-MM-yyyy" />
                                            </span>
                                        </span>
                                    </div>
                                    <div class="card-body ps-0">
                                        <div class="d-flex align-items-center mb-3">
                                            <img class="img-fluid" src="" alt="" />
                                            <div class="flex-1 ms-3">
                                                <span class="badge bg-soft-danger p-2">
                                                    <span class="fw-bold fs-1 text-danger">${medicine.medicineName}</span>
                                                </span><br>

                                                <span class="text-primary fs--1 me-1"><i class="fas fa-star"></i></span>
                                                <span class="mb-0 text-primary">${medicine.quantity}</span>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <a
                                    href="#" 
                                    class="btn btn-sm border border-secondary rounded-pill px-3 text-primary update-btn"
                                    data-bs-toggle="modal"
                                    data-bs-target="#updateMedicineModal"
                                    data-id="${medicine.medicineId}"
                                    data-name="${medicine.medicineName}"
                                    data-image="${medicine.image}"
                                    data-quantity="${medicine.quantity}"
                                    data-price="${medicine.price}"
                                    data-expirydate="<fmt:formatDate value='${medicine.expiryDate}' pattern='yyyy-MM-dd'/>">
                                    <i class="fa fa-edit me-2 text-primary"></i> Update
                                </a>

                                <a href="#"
                                   class="btn btn-sm border border-secondary rounded-pill px-3 text-primary delete-btn"
                                   data-bs-toggle="modal"
                                   data-bs-target="#deleteMedicineModal"
                                   data-id="${medicine.medicineId}"
                                   data-name="${medicine.medicineName}"
                                   data-image="${medicine.image}">
                                    <i class="fa fa-trash me-2 text-primary"></i> Delete
                                </a>

                            </div>


                        </c:forEach>
                    </div>
                </div>

                <div id="updateMedicineModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form id="medicineForm" action="${pageContext.request.contextPath}/MedicineManagement" method="POST">
                                <div class="modal-header">
                                    <h2 class="text-lg font-semibold">Update Medicine</h2>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                                </div>
                                <input type="hidden" id="medicineId" name="medicineId">
                                <div class="modal-body">
                                    <label class="block text-sm font-medium text-gray-700">Medicine Name</label>
                                    <input type="text" id="medicineName" name="medicineName" class="block w-full p-2 mt-1 border rounded" required>
                                </div>
                                <div class="modal-body">
                                    <label class="block text-sm font-medium text-gray-700">Image URL</label>
                                    <input type="text" id="medicineImage" name="image" class="block w-full p-2 mt-1 border rounded" pattern=".*\.(jpg|jpeg|png|gif)$" 
                                           title="Link ?nh ph?i k?t thúc b?ng .jpg, .jpeg, .png ho?c .gif" 
                                           required>
                                </div>
                                <div class="modal-body">
                                    <label class="block text-sm font-medium text-gray-700">Quantity</label>
                                    <input type="number" id="medicineQuantity" name="quantity" class="block w-full p-2 mt-1 border rounded" min="0" step="1" required>
                                </div>
                                <div class="modal-body">
                                    <label class="block text-sm font-medium text-gray-700">Price (VND)</label>
                                    <input type="number" id="medicinePrice" name="price" class="block w-full p-2 mt-1 border rounded" min="0" step="0.01" required>
                                </div>
                                <div class="modal-body">
                                    <label class="block text-sm font-medium text-gray-700">Expiry Date</label>
                                    <input type="date" id="medicineExpiryDate" name="expiryDate" class="block w-full p-2 mt-1 border rounded" required>
                                </div>
                                <div class="modal-footer">
                                    <input type="submit" name="submit" class="btn btn-success" value="Update Changes">
                                    <input type="hidden" name="service" value="updateMedicine">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>


                <div id="deleteMedicineModal" class="modal fade">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <form id="deleteMedicineForm" action="${pageContext.request.contextPath}/MedicineManagement" method="POST">
                                <div class="modal-header">
                                    <h2 class="text-lg font-semibold">Delete This Medicine ?</h2>
                                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                                </div>
                                <input type="hidden" id="deleteMedicineId" name="medicineId">
                                <div class="modal-body">
                                    <label class="block text-sm font-medium text-gray-700">Medicine</label>
                                    <input type="text" id="deleteMedicineName" name="medicineName" class="block w-full p-2 mt-1 border rounded" readonly>
                                </div>
                                <div class="modal-footer">
                                    <input type="submit" name="submit" class="btn btn-danger" value="Delete Medicine">
                                    <input type="hidden" name="service" value="deleteMedicine">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>



            </section>

            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

            <script>
                $(document).ready(function () {
                    $('.update-btn').click(function () {
                        // L?y d? li?u t? data-attribute c?a nút update
                        var id = $(this).data('id');
                        var name = $(this).data('name');
                        var image = $(this).data('image');
                        var quantity = $(this).data('quantity');
                        var price = $(this).data('price');
                        var expiryDate = $(this).data('expirydate');

                        // Gán d? li?u vào các input trong modal
                        $('#medicineId').val(id);
                        $('#medicineName').val(name);
                        $('#medicineImage').val(image);
                        $('#medicineQuantity').val(quantity);
                        $('#medicinePrice').val(price);
                        $('#medicineExpiryDate').val(expiryDate);
                    });
                });
            </script>

            <script>
                $(document).ready(function () {
                    $('.delete-btn').click(function () {
                        var id = $(this).data('id');
                        var name = $(this).data('name');

                        $('#deleteMedicineId').val(id);
                        $('#deleteMedicineName').val(name);
                    });
                });
            </script>





        </main>
        <!-- ===============================================-->
        <!--    End of Main Content-->
        <!-- ===============================================-->




        <!-- ===============================================-->
        <!--    JavaScripts-->
        <!-- ===============================================-->
        <script src="vendors/@popperjs/popper.min.js"></script>
        <script src="vendors/bootstrap/bootstrap.min.js"></script>
        <script src="vendors/is/is.min.js"></script>
        <script src="https://polyfill.io/v3/polyfill.min.js?features=window.scroll"></script>
        <script src="vendors/fontawesome/all.min.js"></script>
        <script src="assets/js/theme.js"></script>
        <!-- Bootstrap Bundle JS (có Popper) -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

        <link href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@200;300;400;600;700;900&amp;display=swap" rel="stylesheet">
    </body>

</html>