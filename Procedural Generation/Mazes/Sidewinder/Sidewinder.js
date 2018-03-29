var Sidewinder = {
    on: function(grid) {
        for (var row of grid.each_row()) {
            var run = [];

            for (var cell of row) {
                run.push(cell);

                var at_eastern_boundary = (cell.east === null);
                var at_northern_boundary = (cell.north === null);

                var should_close_out = at_eastern_boundary ||
                    (!at_northern_boundary && Math.floor(Math.random()*2) === 0);

                if (should_close_out) {
                    var member = run[Math.floor(Math.random()*run.length)];
                    if (member.north) member.link(member.north);
                    run = [];
                } 
                else {
                    cell.link(cell.east);
                }
            }
        }
    }
};

document.addEventListener("DOMContentLoaded", function(event) { 
    var grid = new Grid(10, 10);
    Sidewinder.on(grid);
    document.getElementById('content').innerHTML = grid.toString();
    
});

