document.addEventListener("DOMContentLoaded", () => {
   
    const sidebarItems = document.querySelectorAll(".sidebar .sections");
    const contentSections = document.querySelectorAll(".content .home");
  
    function showSection(index) {
      contentSections.forEach(section => section.style.display = "none");
      contentSections[index].style.display = "block";
    }
    showSection(0);
    sidebarItems.forEach((item, index) => {
      item.addEventListener("click", () => {
        sidebarItems.forEach(btn => btn.classList.remove("active"));
        item.classList.add("active");
        showSection(index);
      });
    });
  });