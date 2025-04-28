Got it — here are the **highlights**:

---

# 🔥 Documentation && Performed Work:

### 1. Put all CSS and JS inside `/static/`
- **CSS** → `/static/css/students.css`
- **JS** → `/static/js/students.js`

---

### 2. Link Static Files in `list.html`
```html
<link rel="stylesheet" th:href="@{/css/students.css}">
<script th:src="@{/js/students.js}"></script>
```

---

### 3. Use Correct IDs
- Table: `id="studentsTable"`
- Table body: `id="studentsTbody"`
- Search input: `id="searchInput"`

✅ So JavaScript can select elements properly.

---

### 4. Add Dark Mode Toggle
```html
<button onclick="toggleDarkMode()">Toggle Dark Mode</button>
```

---

### 5. Implement Search and Sort
- `filterStudents()` on input `keyup`
- `sortTable(index)` on table header `onclick`

---

### 6. Pagination
- `displayTable()` on page load
- `nextPage()` and `prevPage()` buttons

---

### 7. Folder Structure
```bash
static/
 ├── css/
 │    └── students.css
 └── js/
      └── students.js

templates/
 └── students/
      └── list.html
```

---