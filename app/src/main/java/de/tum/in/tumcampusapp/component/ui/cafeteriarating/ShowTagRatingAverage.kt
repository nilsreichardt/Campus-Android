package de.tum.`in`.tumcampusapp.component.ui.cafeteriarating

class ShowTagRatingAverage {
    var tagLabel: String="label"
    var points=1.0
    var max=1
    var min=1
    var std=1.0

    constructor(tagLabel: String, points: Double, max: Int, min: Int, std: Double) {
        this.tagLabel = tagLabel
        this.points = points
        this.max = max
        this.min = min
        this.std = std
    }
}