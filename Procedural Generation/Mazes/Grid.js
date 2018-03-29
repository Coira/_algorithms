'use strict';

function Grid(rows, columns) {
    this.rows = typeof rows != 'undefined' ? rows : -1,
    this.columns = typeof columns != 'undefined' ? columns: -1,
    this.grid = [];
    this.prepare_grid();
    this.configure_cells();
};

Grid.prototype = {
    constructer: Grid,
    
    prepare_grid: function() {
        for (var i = 0; i < this.rows; i++) {
            this.grid[i] = [];
            for (var j = 0; j < this.columns; j++) {
                var cell = new Cell(i, j);
                this.grid[i][j] = cell; 
            }
        }
    },

    configure_cells: function() {
        var iterator = this.each_cell();
        for (let cell of iterator) {
            var row = cell.row;
            var col = cell.column;
            cell.north = this.get(row-1, col);
            cell.south = this.get(row+1,col);
            cell.west = this.get(row,col-1);
            cell.east = this.get(row,col+1);
        }
    },
    
    get: function(row, column) {
        if (row < 0 || row >= this.rows ||
            column < 0 || column >= this.columns) {
            return null;
        }
        return this.grid[row][column];
    },

    size: function() {
        return this.rows * this.columns;
    },
    
    random_cell: function() {
        var row = Math.floor(Math.random() * this.rows);
        var column = Math.floor(Math.random() * this.columns);
        return this.get(row, column);
    },
        
    each_row: function*() {
        for (var row of this.grid) {
            yield row;
        }
    },
    
    each_cell: function*() {
        for (var i = 0; i < this.rows; i++) {
            for (var j = 0; j < this.columns; j++) {
                yield this.get(i, j);
            }
        }
    },

    toString: function() {
        var output = "+";
        for (var i = 0; i < this.columns; i++) {
            output += "...+";
        }
        output += "\n";
        for (let row of this.each_row()) {
            var top = "|";
            var bottom = "+";
            for (let cell of row) {
                if (!cell) {
                    cell = Object.create(Cell);
                }
                var body = "   ";
                var east_boundary = cell.linked(cell.east) ? " " : "|";
                top += body + east_boundary;

                var south_boundary = cell.linked(cell.south) ? "   " : "---";
                var corner = "+";
                bottom += south_boundary + corner;
            }

            output += top + "\n";
            output += bottom + "\n";
        }

        return output;
    }       
};

