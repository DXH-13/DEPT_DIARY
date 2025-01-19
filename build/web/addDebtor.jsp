<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Debtor information</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css"
              integrity="sha384-r4NyP46KrjDleawBgD5tp8Y7UzmLA05oM1iAEQ17CSuDqnUK2+k9luXQOfXJCJ4I" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
        <link href="css/debtor.css" rel="stylesheet">


    </head>
    <body>      
        <form id="debt-form" action="addDebtor" method="post"enctype="multipart/form-data" novalidate>
            <div id="debt-info">
                <div>
                    <a href="diary?id=${sessionScope.userLogin.id}"><img class="exit-button" type="button" src="assets/img/reject.png" class="refresh-icon" ></a> 
                </div>
                <div class="form-title">
                    New debtor information
                </div>                   
                <div class="row mt-2">
                    <div class="col-md-12">
                        <label class="labels">Full Name</label>
                        <input type="text" class="form-control" name="fullName" id="fullName" value="" placeholder="Enter full name" required>
                        <div id="fullName-error" class="text-danger"></div>
                    </div>
                    <div class="col-md-12">
                        <label class="labels">Avatar</label>
                        <input type="file" class="form-control" name="avatar" id="avatar" value="" onchange="previewImage(event)">
                        <img id="avatar-preview" src="#" alt="Preview" style="max-width: 100px; max-height: 100px; margin-top: 10px; display: none; border-radius: 50%">

                    </div>
                    <div class="col-md-12">
                        <label class="labels">Phone Number</label>
                        <input type="text" class="form-control" name="phoneNumber" id="phoneNumber" placeholder="Enter phone number" value="">

                    </div>
                    
                    <div class="col-md-12">
                        <label class="labels">Email</label>
                        <input type="text" class="form-control" name="email" id="email" placeholder="Enter email" value="">

                    </div>
                    <div class="col-md-12">
                        <label class="labels">Address</label>
                        <input type="text" class="form-control" name="address" id="address" placeholder="Enter address" value="">

                    </div>
                    <div class="col-md-12 total-debt">
                        <label class="labels ">Total Debt</label>
                        <input type="text" class="form-control" value="0" readonly>
                    </div>
                </div>
                <div class="mt-3 text-center">
                    <button class="btn btn-primary profile-button add-button" type="submit" style="width: 200px;" id="adddebtor"> <i class="fas fa-plus"></i> ADD NEW</button>
                </div>
            </div>
        </form>  
    </body>
    <!-- Modal Confirmation -->
    <div class="modal fade" id="confirmModal" tabindex="-1" role="dialog" aria-labelledby="confirmModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="confirmModalLabel">Confirm</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Do you want to add this debtor ? 
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" id="confirmAdd">Confirm</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal Success -->
    <div class="modal fade" id="successModal" tabindex="-1" role="dialog" aria-labelledby="successModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="successModalLabel">Success</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Add new debtor successfully!!!
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>



    <!-- K?t n?i Bootstrap JS và jQuery n?u ch?a có -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.bundle.min.js"></script>

    <script src="js/debtor.js"></script>      


</html>