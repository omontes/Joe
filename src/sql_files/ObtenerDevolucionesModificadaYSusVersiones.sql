SELECT Dev.Fecha ,Dev.`idDevolucion` AS NumFact,Dev.`idVersionDev`,C.`Nombre` AS Cliente,
V.Nombre AS Vendedor,Dev.Descuento,(Dev.TotalFacturado / (1 - ((Dev.Descuento) / 100))) AS SubTotal,
Dev.TotalFacturado,Dev.`Nota`
FROM devolucion AS Dev, Productocantidaddev AS PCD, Persona AS C, Persona AS V
WHERE Dev.`idDevolucion` = ? AND Dev.`idClienteDev`=C.`idPersona` AND 
Dev.`idVendedorDev` = V.`idPersona`
AND Dev.`idVersionDev` = PCD.`idVersionDevProd`
GROUP BY Dev.`idVersionDev`
ORDER BY Dev.`idVersionDev` DESC;