SELECT M.idMovimientos AS NumEntrada,M.`Fecha`,M.`Detalle`
FROM movimientos AS M
WHERE M.`idTipoMovimiento`='1'
ORDER BY M.idMovimientos DESC LIMIT 100;
