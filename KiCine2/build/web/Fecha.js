document.addEventListener('DOMContentLoaded', function() {
    const dateInput = document.getElementById('lanzamiento');

    // Agrega un evento 'input' para actualizar la visualización del valor
    dateInput.addEventListener('input', function() {
        // Obtén el valor del input
        const inputValue = dateInput.value;

        // Reemplaza '/' por '-'
        const formattedValue = inputValue.replace(/\//g, '-');

        // Establece el valor formateado en el input
        dateInput.value = formattedValue;
    });
});
