SELECT M.idMovimientos AS NumSalida,M.`Fecha`,M.`Detalle`
FROM movimientos AS M
WHERE M.`idTipoMovimiento`='2'
ORDER BY M.idMovimientos DESC LIMIT 100;

