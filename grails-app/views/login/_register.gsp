<body>
<div class="col-sm-12">
    <div class="panel panel-primary">
        <div class="panel-heading">Register</div>

        <div class="panel-body">
            <g:form controller="login" action="register">
                <div class="form-group col-sm-12">

                    <label for="firstName">First Name*</label>
                    <input type="text" name="firstName" value="${firstName}" class="form-control" id="firstName"
                           placeholder="Enter First Name" required>
                </div>

                <div class="form-group col-sm-12">
                    <label for="lastName">Last Name*</label>
                    <input type="text" name="lastName" value="${lastName}" class="form-control" id="lastName"
                           placeholder="Enter last Name" required>
                </div>

                <div class="form-group col-sm-12">
                    <label for="email">Email*</label>
                    <input type="email" name="email" value="${email}" class="form-control" id="email"
                           placeholder="Enter Email" required>
                </div>

                <div class="form-group col-sm-12">
                    <label for="password">Password*</label>
                    <input type="password" name="password" value="${password}" class="form-control" id="password"
                           pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
                           title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
                           placeholder="Enter Password" required>
                    <input type="checkbox" onclick="myFunction()">Show Password
                </div>

                <div class="form-group col-sm-12">
                    <label for="confirmpassword">Confirm Password*</label>
                    <input type="password" name="confirmpassword" value="${confirmpassword}" class="form-control"
                           id="confirmpassword"
                           placeholder="Enter Confirm Password" required>
                </div>

                <div class="form-group col-sm-12">
                    Photo:<br>
                    <input type="file" name="fileupload" value="fileupload" id="fileupload"><br><br>
                </div>

                <div class="form-group col-sm-12">
                    <button type="submit" class="btn btn-primary"
                            style="float: right; margin-top: -30px;">Submit</button>
                </div>
                <script>
                    var password = document.getElementById("password")
                        , confirmpassword = document.getElementById("confirmpassword");

                    function validatePassword() {
                        if (password.value != confirmpassword.value) {
                            confirmpassword.setCustomValidity("Passwords Don't Match");
                        } else {
                            confirmpassword.setCustomValidity('');
                        }
                    }

                    password.onchange = validatePassword;
                    confirmpassword.onkeyup = validatePassword;

                    function myFunction() {
                        var x = document.getElementById("password");
                        if (x.type === "password") {
                            x.type = "text";
                        } else {
                            x.type = "password";
                        }
                    }
                </script>
            </g:form>
        </div>
    </div>
</div>
</body>



