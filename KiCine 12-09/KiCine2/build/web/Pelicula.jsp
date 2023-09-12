<%-- 
    Document   : Pelicula
    Created on : jul 21, 2023, 12:30:00 p.m.
    Author     : Windows 10
--%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <title>Document</title>
        <style>

            * {
                margin: 0;
                padding: 0;
                box-sizing: border-box;
            }
            body {
                font-family: 'Inter', sans-serif;
                font-weight: 400;
            }
            .formbold-mb-3 {
                margin-bottom: 15px;
            }

            .formbold-main-wrapper {
                display: flex;
                align-items: center;
                justify-content: center;
                padding: 48px;
            }

            .formbold-form-wrapper {
                margin: 0 auto;
                max-width: 570px;
                width: 100%;
                background: white;
                padding: 40px;
            }

            .formbold-img {
                display: block;
                margin: 0 auto 45px;
            }

            .formbold-input-wrapp > div {
                display: flex;
                gap: 20px;
            }

            .formbold-input-flex {
                display: flex;
                gap: 20px;
                margin-bottom: 15px;
            }
            .formbold-input-flex > div {
                width: 50%;
            }
            .formbold-form-input {
                width: 100%;
                padding: 13px 22px;
                border-radius: 5px;
                border: 1px solid #dde3ec;
                background: #ffffff;
                font-weight: 500;
                font-size: 16px;
                color: #536387;
                outline: none;
                resize: none;
            }
            .formbold-form-input::placeholder,
            select.formbold-form-input,
            .formbold-form-input[type='date']::-webkit-datetime-edit-text,
            .formbold-form-input[type='date']::-webkit-datetime-edit-month-field,
            .formbold-form-input[type='date']::-webkit-datetime-edit-day-field,
            .formbold-form-input[type='date']::-webkit-datetime-edit-year-field {
                color: rgba(83, 99, 135, 0.5);
            }

            .formbold-form-input:focus {
                border-color: #6a64f1;
                box-shadow: 0px 3px 8px rgba(0, 0, 0, 0.05);
            }
            .formbold-form-label {
                color: #07074D;
                font-weight: 500;
                font-size: 14px;
                line-height: 24px;
                display: block;
                margin-bottom: 10px;
            }

            .formbold-form-file-flex {
                display: flex;
                align-items: center;
                gap: 20px;
            }
            .formbold-form-file-flex .formbold-form-label {
                margin-bottom: 0;
            }
            .formbold-form-file {
                font-size: 14px;
                line-height: 24px;
                color: #536387;
            }
            .formbold-form-file::-webkit-file-upload-button {
                display: none;
            }
            .formbold-form-file:before {
                content: 'Upload file';
                display: inline-block;
                background: #EEEEEE;
                border: 0.5px solid #FBFBFB;
                box-shadow: inset 0px 0px 2px rgba(0, 0, 0, 0.25);
                border-radius: 3px;
                padding: 3px 12px;
                outline: none;
                white-space: nowrap;
                cursor: pointer;
                color: #637381;
                font-weight: 500;
                font-size: 12px;
                line-height: 16px;
                margin-right: 10px;
            }

            .formbold-btn {
                text-align: center;
                width: 100%;
                font-size: 16px;
                border-radius: 5px;
                padding: 14px 25px;
                border: none;
                font-weight: 500;
                background-color: #6a64f1;
                color: white;
                cursor: pointer;
                margin-top: 25px;
            }
            .formbold-btn:hover {
                box-shadow: 0px 3px 8px rgba(0, 0, 0, 0.05);
            }

            .formbold-w-45 {
                width: 45%;
            }
        </style>
    </head>
    <body>
        <h1 style="text-align: center;">Pelicula</h1>
        <div class="formbold-main-wrapper">

            <!-- Author: FormBold Team -->
            <!-- Learn More: https://formbold.com -->
            <div class="formbold-form-wrapper">


                <form action="Controlador?menu=Pelicula" method="POST" enctype="multipart/form-data">
                    <div class="formbold-input-flex">
                        <div>
                            <label for="titulo" class="formbold-form-label"> Título </label>
                            <input
                                type="text"
                                name="titulo"
                                id="titulo"                                
                                class="formbold-form-input"
                                />
                        </div>

                        <div>
                            <label for="genero" class="formbold-form-label"> Género </label>
                            <input
                                type="text"
                                name="genero"
                                id="genero"
                                class="formbold-form-input"
                                />
                        </div>
                    </div>

                    <div class="formbold-input-flex">
                        <div>
                            <label for="director" class="formbold-form-label"> Director </label>
                            <input
                                type="text"
                                name="director"
                                id="director"
                                class="formbold-form-input"
                                />
                        </div>

                        <div>
                            <label class="formbold-form-label">Duración</label>

                            <input
                                type="text"
                                name="duracion"
                                id="duracion"
                                class="formbold-form-input"
                                />
                            <!--<select class="formbold-form-input" name="occupation" id="occupation">
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                            <option value="others">Others</option>
                            </select>-->
                        </div>
                    </div>


                    <div class="formbold-mb-3">
                        <label for="calificacion" class="formbold-form-label"> Calificación </label>
                        <input
                            type="text"
                            name="calificacion"
                            id="calificacion"
                            class="formbold-form-input"
                            />
                    </div>

                    <div class="formbold-mb-3">
                        <label for="year" class="formbold-form-label"> Año de lanzamiento </label>
                        <input type="date" name="lanzamiento" id="lanzamiento" class="formbold-form-input" />
                    </div>

                    <div class="formbold-mb-3">
                        <label for="idioma" class="formbold-form-label"> Idioma </label>

                        <input
                            type="text"
                            name="idioma"
                            id="idioma"
                            placeholder="Lenguaje de la película"
                            class="formbold-form-input formbold-mb-3"
                            />
                    </div>
                    
                    <div class="formbold-mb-3">
                        <label for="foto" class="formbold-form-label"> Foto </label>

                        <input
                            type="file"
                            name="foto"
                            id="foto"
                            class="formbold-form-input formbold-mb-3"
                            />
                    </div>

                    <div class="formbold-mb-3">
                        <label for="sinopsis" class="formbold-form-label">
                            Sinopsis
                        </label>
                        <textarea
                            rows="6"
                            name="sinopsis"
                            id="sinopsis"
                            class="formbold-form-input"
                            ></textarea>
                    </div>

                    <!--<div class="formbold-form-file-flex">
                      <label for="upload" class="formbold-form-label">
                        Upload Resume
                      </label>
                      <input
                        type="file"
                        name="upload"
                        id="upload"
                        class="formbold-form-file"
                      />
                    </div>-->

                    <input type="submit" href="Controlador?menu=Pelicula&accion=Agregar" name="accion" value="Agregar" class="formbold-btn">
                </form>
            </div>
        </div>
        
        <script serc="Fecha.js"></script>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
    </body>
</html>