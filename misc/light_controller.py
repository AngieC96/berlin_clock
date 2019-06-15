yellow = (10, 5, 0)
red    = (10, 0, 0)
off    = (0, 0, 0)

lights = [yellow,
        red, red, red, red,
        red, red, red, red,
        yellow, yellow, red,
        yellow, yellow, red,
        yellow, yellow, red,
        yellow, yellow,
        yellow, yellow, yellow, yellow]

import board
import neopixel

leds = neopixel.NeoPixel(board.D18, len(lights))

while True:

    statuses = input()
    statuses = [x for x in statuses if x in '01']

    out = [light if status == '1' else off for light, status in zip(lights, statuses)]
    out[1:5] = reversed( out[1:5] )
    out[9:20] = reversed( out[9:20] )

    leds[:] = out[::-1]
