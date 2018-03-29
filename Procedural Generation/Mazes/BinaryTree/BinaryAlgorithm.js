var BinaryTree = {
    on: function(grid) {
        for (let cell of grid.each_cell()) {
            var neighbours = [];
            if (cell.north) neighbours.push(cell.north);
            if (cell.east) neighbours.push(cell.east);

            var index = Math.floor(Math.random() * neighbours.length);
            var neighbour = neighbours[index];
            if (neighbour) cell.link(neighbour);
        }
    }
}; 

document.addEventListener("DOMContentLoaded", function(event) { 
    var grid = new Grid(10, 10);
    BinaryTree.on(grid);
    document.getElementById('content').innerHTML = grid.toString();
    
});
