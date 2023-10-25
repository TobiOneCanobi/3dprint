union()
{
    union()
    {
        translate([0.0, 0.0, -10.0])
        {
            linear_extrude(height = 3.0, twist = 0.0, scale = 1.0, slices = 1, center = true)
            {
                scale([10.0, 50.0])
                {
                    M8();
                }
            }
        }
        translate([0.0, 10.0, 0.0])
        {
            rotate([90.0, 0.0, 0.0])
            {
                linear_extrude(height = 3.0, twist = 0.0, scale = 1.0, slices = 1, center = true)
                {
                    scale([10.0, 50.0])
                    {
                        M8();
                    }
                }
            }
        }
    }
    union()
    {
        translate([0.0, 0.0, 10.0])
        {
            linear_extrude(height = 3.0, twist = 0.0, scale = 1.0, slices = 1, center = true)
            {
                scale([10.0, 50.0])
                {
                    M8();
                }
            }
        }
        translate([0.0, -10.0, 0.0])
        {
            rotate([90.0, 0.0, 0.0])
            {
                linear_extrude(height = 3.0, twist = 0.0, scale = 1.0, slices = 1, center = true)
                {
                    scale([10.0, 50.0])
                    {
                        M8();
                    }
                }
            }
        }
    }
}

module M8()
{
    polygon
    (
        points =
        [
            [-0.5, -0.5], 
            [0.5, -0.5], 
            [0.5, 0.5], 
            [-0.5, 0.5]
        ],
        paths =
        [
            [0, 1, 2, 3]
        ]
    );
}
