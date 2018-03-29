'use strict';

function Cell(row, column) {
    this.row = typeof row != 'undefined' ? row : -1; 
    this.column = typeof column != 'undefined' ? column : -1; 
    
    this.links = [];
    
    this.north = null;
    this.south = null;
    this.east = null;
    this.west = null;
};

Cell.prototype = {
    constructor: Cell,

    link: function(cell, bidi) {
        bidi = (typeof bidi != 'undefined') ? bidi : true;
        this.links.push(cell);
        if (bidi) cell.link(this, false);
        
    },

    unlink: function(cell) {
        bidi = (typeof bidi != 'undefined') ? bidi : true;
        var index = links.indexOf(cell);
        if (index > -1) {
            this.links.splice(index, 1);
        }
        if (bidi) cell.unlink(this, false);
   },

    linked: function(cell) {
        return this.links.indexOf(cell) != -1;
    },

    neighbours: function() {
        var list = [];

        if (this.north) list.push(this.north);
        if (this.south) list.push(this.south);
        if (this.east) list.push(this.east);
        if (this.west) list.push(this.west);
        
        return list;
    } 
};
