param($unit)
$root = Get-Location;

wt -w 0 nt -d "$root./application/web/source" --title "CLIENT";
wt -w 0 nt -d "$root./application/web/test" --title "CLIENT IT";
# wt -w 0 nt -d "$root./service/purchase/source" --title "PURCHASE SERVICE";
# wt -w 0 nt -d "$root./service/purchase/test" --title "PURCHASE SERVICE IT";


if ($unit -eq "true") {
    wt -w 0 nt -d "$root./application/web/source" --title "CLIENT UT";
}
