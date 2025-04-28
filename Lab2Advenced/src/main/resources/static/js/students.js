
function toggleDarkMode() {
    document.body.classList.toggle('dark-mode');
}

function filterStudents() {
    let input = document.getElementById('searchInput').value.toLowerCase();
    let rows = document.getElementById('studentsTbody').getElementsByTagName('tr');
    for (let row of rows) {
        let text = row.innerText.toLowerCase();
        row.style.display = text.includes(input) ? '' : 'none';
    }
}

let sortDirection = true;
function sortTable(columnIndex) {
    let table = document.getElementById('studentsTable');
    let tbody = table.tBodies[0];
    let rows = Array.from(tbody.querySelectorAll('tr'));

    rows.sort((a, b) => {
        let aText = a.children[columnIndex].innerText;
        let bText = b.children[columnIndex].innerText;
        return (aText > bText ? 1 : -1) * (sortDirection ? 1 : -1);
    });

    sortDirection = !sortDirection;
    rows.forEach(row => tbody.appendChild(row));
}

let currentPage = 1;
const rowsPerPage = 5;
function displayTable() {
    let tbody = document.getElementById('studentsTbody');
    let rows = Array.from(tbody.getElementsByTagName('tr'));
    rows.forEach((row, index) => {
        row.style.display = (index >= (currentPage - 1) * rowsPerPage && index < currentPage * rowsPerPage) ? '' : 'none';
    });
}
function nextPage() {
    console.log("it Works");
    let tbody = document.getElementById('studentsTbody');
    let rows = tbody.getElementsByTagName('tr').length;
    if (currentPage * rowsPerPage < rows) {
        currentPage++;
        displayTable();
    }
}
function prevPage() {
    console.log("it Works");
    if (currentPage > 1) {
        currentPage--;
        displayTable();
    }
}
window.onload = displayTable;
